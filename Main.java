public class Main {
    public static void main(String[] args) {
        CandidatoDAO candidatoDAO = new CandidatoSQLiteDAO();
        PartidoDAO partidoDAO = new PartidoSQLiteDAO();
        CargoDAO cargoDAO = new CargoSQLiteDAO();

        Candidato candidato = new Candidato(1, "João", new Partido(1, "Partido 1", "P1"), new Cargo(1, "Cargo 1"));
        candidatoDAO.salvar(candidato);

        candidato = new Candidato(2, "Maria", new Partido(2, "Partido 2", "P2"), new Cargo(2, "Cargo 2"));
        candidatoDAO.salvar(candidato);

        candidato = new Candidato(3, "Pedro", new Partido(3, "Partido 3", "P3"), new Cargo(3, "Cargo 3"));
        candidatoDAO.salvar(candidato);

        candidato = new Candidato(4, "Joana", new Partido(4, "Partido 4", "P4"), new Cargo(4, "Cargo 4"));
        candidatoDAO.salvar(candidato);

        candidato = new Candidato(5, "José", new Partido(5, "Partido 5", "P5"), new Cargo(5, "Cargo 5"));
        candidatoDAO.salvar(candidato);

        candidato = new Candidato(6, "José", new Partido(6, "Partido 6", "P6"), new Cargo(6, "Cargo 6"));
        candidatoDAO.salvar(candidato);

        candidato = new Candidato(7, "José", new Partido(7, "Partido 7", "P7"), new Cargo(7, "Cargo 7"));
        candidatoDAO.salvar(candidato);

        candidato = new Candidato(8, "José", new Partido(8, "Partido 8", "P8"), new Cargo(8, "Cargo 8"));
        candidatoDAO.salvar(candidato);
    }
}
