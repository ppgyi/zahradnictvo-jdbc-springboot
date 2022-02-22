package sk.pgyi.zahradnictvox.services.implementacia;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import sk.pgyi.zahradnictvox.domeny.Klient;
import sk.pgyi.zahradnictvox.mapper.KlientRowMapper;
import sk.pgyi.zahradnictvox.services.api.KlientService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class KlientServiceImplementacia implements KlientService {

    private final JdbcTemplate jdbcTemplate;
    private final KlientRowMapper klientRowMapper = new KlientRowMapper();

    public KlientServiceImplementacia(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Klient> getKlienti() {
        final String sql = "select * from klienti";
        return jdbcTemplate.query(sql,klientRowMapper);
    }

    @Override
    public Klient getKlient(Integer id) {
        final String sql = "select * from klienti where klienti.id =" + id;
        try {
            return jdbcTemplate.queryForObject(sql,klientRowMapper);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Integer addKlient(Klient klient) {
        final String sql = "insert into klienti(meno, priezvisko, adresa, telefon, email) values (?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, klient.getMeno());
                preparedStatement.setString(2, klient.getPriezvisko());
                preparedStatement.setString(3, klient.getAdresa());
                preparedStatement.setString(4, klient.getTelefon());
                preparedStatement.setString(5, klient.geteMail());
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
    public void deleteKlient(Integer id) {
        final String sql = "delete from klienti where id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateKlient(Integer id, Klient klient) {
        final String sql = "update klienti set meno = ?, priezvisko = ?, adresa = ?, telefon = ?, email = ? where id = ?";
        jdbcTemplate.update(sql, klient.getMeno(), klient.getPriezvisko(), klient.getAdresa(), klient.getTelefon(), klient.geteMail(), id);
    }
}
