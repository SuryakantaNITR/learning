package com.learning.theory;

interface Animatable {
	public void animate();
}

class GameShape {
	public void movePiece() {
		System.out.println("Moving piece in Game");
	}
}

class PlayerPiece extends GameShape implements Animatable{
	public void animate() {
		System.out.println("Animate in PlayerPiece");
	}
	public void movePiece() {
		System.out.println("Moving Piece in PlayerPiece");
	}
}
public class RunTimeBinding {
	public static void main(String[] args) {
		PlayerPiece p = new PlayerPiece();
		p.animate();
		p.movePiece();
		GameShape g = new PlayerPiece();
		g.movePiece();
		Animatable a  = new PlayerPiece();
		a.animate();
	}

}
