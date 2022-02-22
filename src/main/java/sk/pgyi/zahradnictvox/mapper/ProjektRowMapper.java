package sk.pgyi.zahradnictvox.mapper;

import org.springframework.jdbc.core.RowMapper;
import sk.pgyi.zahradnictvox.domeny.Projekt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjektRowMapper implements RowMapper<Projekt> {
    @Override
    public Projekt mapRow(ResultSet rs, int rowNum) throws SQLException {
        Projekt projekt = new Projekt();
        projekt.setId(rs.getInt("id"));
        projekt.setKlientId(rs.getInt("klientId"));
        projekt.setNazov(rs.getString("nazov"));
        projekt.setPopis(rs.getString("popis"));
        projekt.setDatum(rs.getDate("datum"));
        projekt.setAdresaprojektu(rs.getString("adresaprojektu"));
        projekt.setUkoncene(rs.getBoolean("ukoncene"));
        return projekt;
    }
}
