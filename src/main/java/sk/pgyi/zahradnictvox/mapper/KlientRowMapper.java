package sk.pgyi.zahradnictvox.mapper;

import org.springframework.jdbc.core.RowMapper;
import sk.pgyi.zahradnictvox.domeny.Klient;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KlientRowMapper implements RowMapper<Klient> {
    @Override
    public Klient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Klient klient = new Klient();
        klient.setId(rs.getInt("id"));
        klient.setMeno(rs.getString("meno"));
        klient.setPriezvisko(rs.getString("priezvisko"));
        klient.setAdresa(rs.getString("adresa"));
        klient.setTelefon(rs.getString("telefon"));
        klient.seteMail(rs.getString("email"));
        return klient;
    }
}
