package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class UI {

	public static void printBoard(ChessPiece[][] pieces) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], false);

			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");

	}
	
	
	
	
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for (int i = 0; i < pieces.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pieces.length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);

			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");

	}

	public static void clearScreen() {
		for (int i = 0; i < 30; i++) {
		    System.out.println();
		}
	}
	
	
	public static void printMatch(ChessMatch chessMatch) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		System.out.println("Turn: "+ chessMatch.getTurn());
		System.out.println("Waiting player: "+ chessMatch.getCurrentPlayer());
	}

	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Error reading ChessPosition");
		}
	}

	private static void printPiece(ChessPiece piece, boolean background) {
		if (background) {
			System.out.print("["+"-"+"]");
		}
		if (piece == null) {
			System.out.print("-");
		} else {
			System.out.print(piece);
		}

		System.out.print(" ");
	}

}
