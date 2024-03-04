package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Viagem 
{
	int codigo;
	Onibus onibus;
	Motorista motorista;
	int horaSaida;
	int horaChegada;
	String partida;
	String destino;
}