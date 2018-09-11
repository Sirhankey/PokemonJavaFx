package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Pokemon {
    static ArrayList<String> pokemons = new ArrayList<String>();
    static ArrayList<String> pokemonsQ = new ArrayList<String>();
    static ArrayList<Integer> pokemonsJogados = new ArrayList<Integer>();
    static ArrayList<Integer> pokemonsNumeros = new ArrayList<Integer>();
    Controller randomControl = new Controller();
    Player newPlayer;
    String[] pokemonList = new String[]{"Bulbasaur","Ivysaur","Venusaur","Charmander","Charmeleon","Charizard","Squirtle","Wartortle","Blastoise","Caterpie","Metapod","Butterfree","Weedle","Kakuna","Beedrill","Pidgey","Pidgeotto","Pidgeot","Rattata","Raticate","Spearow","Fearow","Ekans",	"Arbok",	"Pikachu",	"Raichu",	"Sandshrew",	"Sandslash",	"Nidoran♀",	"Nidorina",	"Nidoqueen",	"Nidoran♂",	"Nidorino",	"Nidoking",	"Clefairy",	"Clefable",	"Vulpix",	"Ninetales",	"Jigglypuff",	"Wigglytuff",	"Zubat",	"Golbat",	"Oddish",	"Gloom",	"Vileplume",	"Paras",	"Parasect",	"Venonat",	"Venomoth",	"Diglett",	"Dugtrio",	"Meowth",	"Persian",	"Psyduck",	"Golduck",	"Mankey",	"Primeape",	"Growlithe",	"Arcanine",	"Poliwag",	"Poliwhirl",	"Poliwrath",	"Abra",	"Kadabra",	"Alakazam",	"Machop",	"Machoke",	"Machamp",	"Bellsprout",	"Weepinbell",	"Victreebel",	"Tentacool",	"Tentacruel",	"Geodude",	"Graveler",	"Golem",	"Ponyta",	"Rapidash",	"Slowpoke",	"Slowbro",	"Magnemite",	"Magneton",	"Farfetch'd",	"Doduo",	"Dodrio",	"Seel",	"Dewgong",	"Grimer",	"Muk",	"Shellder",	"Cloyster",	"Gastly",	"Haunter",	"Gengar",	"Onix",	"Drowzee",	"Hypno",	"Krabby",	"Kingler",	"Voltorb",	"Electrode",	"Exeggcute",	"Exeggutor",	"Cubone",	"Marowak",	"Hitmonlee",	"Hitmonchan",	"Lickitung",	"Koffing",	"Weezing",	"Rhyhorn",	"Rhydon",	"Chansey",	"Tangela",	"Kangaskhan",	"Horsea",	"Seadra",	"Goldeen",	"Seaking",	"Staryu",	"Starmie",	"Mr. Mime",	"Scyther",	"Jynx",	"Electabuzz",	"Magmar",	"Pinsir",	"Tauros",	"Magikarp",	"Gyarados",	"Lapras",	"Ditto",	"Eevee",	"Vaporeon",	"Jolteon",	"Flareon",	"Porygon",	"Omanyte",	"Omastar",	"Kabuto",	"Kabutops",	"Aerodactyl",	"Snorlax",	"Articuno",	"Zapdos",	"Moltres",	"Dratini",	"Dragonair",	"Dragonite",	"Mewtwo",	"Mew"};

    public void shuffleList(){
        Collections.shuffle(pokemonsNumeros);
    }

    public int numeroPkmnVez(int i){
        return pokemonsNumeros.get(i);
    }


    public String imagemVez(int i){

        return  pokemonsQ.get(pokemonsNumeros.get(i));
    }
    public String respostaImagemVez(int i){
        return pokemons.get(pokemonsNumeros.get(i));
    }

    public String  getPokemonName(int i){

        return pokemonList[pokemonsNumeros.get(i)];

    }

    public void setPokemons(){
        for (int i = 0;i<151;i++){
            if(i<9){
                pokemonsQ.add("00"+(i+1)+"Q.png");
                pokemons.add("00"+(i+1)+".png");
            }
            else if (i<99){
                pokemonsQ.add("0"+(i+1)+"Q.png");
                pokemons.add("0"+(i+1)+".png");
            }
            else {
                pokemonsQ.add((i+1)+"Q.png");
                pokemons.add((i+1)+".png");
            }
            System.out.println(pokemons.get(i));
            System.out.println(pokemonsQ.get(i));
            pokemonsNumeros.add(i);
        }
        shuffleList();
    }






}
