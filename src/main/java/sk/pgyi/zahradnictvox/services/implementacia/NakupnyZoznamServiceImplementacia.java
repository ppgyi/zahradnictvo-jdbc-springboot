package sk.pgyi.zahradnictvox.services.implementacia;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import sk.pgyi.zahradnictvox.domeny.NakupnyZoznam;
import sk.pgyi.zahradnictvox.mapper.NakupnyZoznamRowMapper;
import sk.pgyi.zahradnictvox.services.api.NakupnyZoznamService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class NakupnyZoznamServiceImplementacia implements NakupnyZoznamService {

    private final JdbcTemplate jdbcTemplate;
    private final NakupnyZoznamRowMapper nakupnyZoznamRowMapper = new NakupnyZoznamRowMapper();

    public NakupnyZoznamServiceImplementacia(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<NakupnyZoznam> getNakupnyZoznam() {
        final String sql = "select * from nakupnyzoznam";
        return jdbcTemplate.query(sql,nakupnyZoznamRowMapper);
    }

    @Override
    public Integer addPolozkaNakZoz(NakupnyZoznam nakupnyZoznam) {
        final String sql = "insert into nakupnyzoznam(nazov, pocet) values (?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, nakupnyZoznam.getNazov());
                preparedStatement.setInt(2, nakupnyZoznam.getPocet());
                return preparedStatement;
            }
        }, keyHolder);

        if (keyHolder.getKey() != null){
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    @Override
    public NakupnyZoznam getPolozkaNakZoz(Integer id) {
        final String sql = "select * from nakupnyzoznam where nakupnyzoznam.id =" + id;
        try {
            return jdbcTemplate.queryForObject(sql,nakupnyZoznamRowMapper);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public void deletePolozkaNakZoz(Integer id) {
        final String sql = "delete from nakupnyzoznam where id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updatePolozkaNakZoz(Integer id, NakupnyZoznam nakupnyZoznam) {
        final String sql = "update nakupnyzoznam set nazov = ?, pocet = ? where id = ?";
        jdbcTemplate.update(sql, nakupnyZoznam.getNazov(), nakupnyZoznam.getPocet(), id);
    }
}
