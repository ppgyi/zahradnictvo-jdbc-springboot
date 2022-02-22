package sk.pgyi.zahradnictvox.services.implementacia;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import sk.pgyi.zahradnictvox.domeny.Projekt;
import sk.pgyi.zahradnictvox.mapper.ProjektUkoncenyRowMapper;
import sk.pgyi.zahradnictvox.services.api.ProjektUkoncenyService;

import java.sql.*;
import java.util.List;

@Service
public class ProjektUkoncenyServiceImplementacia implements ProjektUkoncenyService {

    private final JdbcTemplate jdbcTemplate;
    private final ProjektUkoncenyRowMapper projektUkoncenyRowMapper = new ProjektUkoncenyRowMapper();

    public ProjektUkoncenyServiceImplementacia(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Projekt> getProjekty() {
        final String sql = "select * from projektyukoncene";
        return jdbcTemplate.query(sql, projektUkoncenyRowMapper);
    }

    @Override
    public Projekt getProjekt(Integer id) {
        final String sql = "select * from projektyukoncene where projektyukoncene.id = " +id;
        try {
            return jdbcTemplate.queryForObject(sql,projektUkoncenyRowMapper);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public List<Projekt> getProjketyByUserId(Integer klinetId) {
        final String sql = "select * from projektyukoncene where projektyukoncene.klientId = " + klinetId;
        try {
            return jdbcTemplate.query(sql, projektUkoncenyRowMapper);
        } catch (EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public Integer addProjekt(Projekt projekt) {
        final String sql = "insert into projektyukoncene(klientId, nazov, popis, datum, adresaprojektu, ukoncene) values (?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, projekt.getKlientId());
                preparedStatement.setString(2, projekt.getNazov());
                preparedStatement.setString(3, projekt.getPopis());
                preparedStatement.setDate(4, projekt.getDatum());
                preparedStatement.setString(5, projekt.getAdresaprojektu());
                preparedStatement.setBoolean(6, projekt.isUkoncene());
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
    public void deleteProjekt(Integer id) {
        final String sql = "delete from projektyukoncene where id = ? ";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateProjekt(Integer id, Projekt projekt) {
        final String sql = "update projektyukoncene set nazov = ?, popis = ?, datum = ?, adresaprojektu = ?, ukoncene = ? where id = ?";
        jdbcTemplate.update(sql, projekt.getNazov(), projekt.getPopis(), projekt.getDatum(), projekt.getAdresaprojektu(), projekt.isUkoncene(), id);
    }
}
