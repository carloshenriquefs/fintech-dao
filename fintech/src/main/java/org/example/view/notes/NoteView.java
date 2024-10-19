package org.example.view.notes;

import org.example.dao.notes.impl.NotesDaoImpl;
import org.example.model.Note;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static org.example.constants.Constants.INSERT_NOTE;
import static org.example.constants.Constants.NOTES_LIST;
import static org.example.constants.Constants.NOTE_FOUND;
import static org.example.exception.ErrorTypeEnum.ERROR_CONNECTING_TO_DATABASE;
import static org.example.menu.Menu.exit;
import static org.example.menu.Menu.invalidOption;
import static org.example.menu.Menu.showMenu;

public class NoteView {

    private static Scanner scanner = new Scanner(System.in);
    private static NotesDaoImpl dao;


    public static void main(String[] args) {

        try {

            dao = new NotesDaoImpl();

            int opcao;

            do {

                showMenu();

                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        insert();
                        break;
                    case 2:
                        getById();
                        break;
                    case 3:
                        getAll();
                        break;
                    case 0:
                        exit();
                        break;
                    default:
                        invalidOption();
                }

            } while (opcao != 0);

            dao.closeConnection();

        } catch (SQLException e) {
            System.err.println(ERROR_CONNECTING_TO_DATABASE + e.getMessage());
        }
    }

    private static void insert() {
        System.out.println("\n" + INSERT_NOTE);

        System.out.print("\nInsira o ID do usuário associado à nota: ");
        Long id = scanner.nextLong();

        System.out.print("Digite o titulo da notificação: ");
        String titulo = scanner.next() + scanner.nextLine();

        System.out.print("Digite o comentário da notificação: ");
        String comentario = scanner.next() + scanner.nextLine();

        System.out.print("Digite a data da notificação: ");
        String dataNota = scanner.next() + scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(dataNota, formatter);

        Note notes = new Note(id, titulo, comentario, data);

        dao.insert(notes, id);
    }

    private static void getById() {
        System.out.print("Digite o código da notificação: ");
        long codigo = scanner.nextLong();

        Note note = dao.getById(codigo);

        if (note == null) {
            System.out.println("\nNOTE: " + codigo + " NÃO ENCONTRADO!");
        } else {
            System.out.println("\nNOTE: " + codigo + " ENCONTRADO!");
        }

        System.out.println("\n" + NOTE_FOUND);

        formatNote();
        System.out.printf("|%5s  | %-20s | %-20s | %-20s  |%n",
                note.getCode(),
                note.getTitle(),
                note.getComentary(),
                note.getNote()
        );
        System.out.println("-------------------------------------------------------------------------------");
    }

    private static void getAll() {
        List<Note> notes = dao.getAll();

        System.out.println("\n" + NOTES_LIST);

        for (Note note : notes) {
            formatNote();

            System.out.printf("|%5s   | %-20s | %-20s | %-20s   |%n",
                    note.getCode(),
                    note.getTitle(),
                    note.getComentary(),
                    note.getUserId()
            );
            System.out.println("-------------------------------------------------------------------------------");
        }
    }

    public static void formatNote() {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                              [SEARCH RESULT]                                |");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("|%5s| %-20s | %-20s | %-20s  |%n", "USER ID", "TITLE", "COMENTARY", "DATA NOTE");
        System.out.println("-------------------------------------------------------------------------------");
    }
}
