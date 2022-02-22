package sk.pgyi.zahradnictvox.mapper;

import org.springframework.jdbc.core.RowMapper;
import sk.pgyi.zahradnictvox.domeny.NakupnyZoznam;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NakupnyZoznamRowMapper implements RowMapper<NakupnyZoznam> {
    @Override
    public NakupnyZoznam mapRow(ResultSet rs, int rowNum) throws SQLException {
        NakupnyZoznam nakupnyZoznam = new NakupnyZoznam();
        nakupnyZoznam.setId(rs.getInt("id"));
        nakupnyZoznam.setNazov(rs.getString("nazov"));
        nakupnyZoznam.setPocet(rs.getInt("pocet"));
        return nakupnyZoznam;
    }
}
