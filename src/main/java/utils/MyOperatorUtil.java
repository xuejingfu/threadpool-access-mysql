package utils;

import bean.Book;
import bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by xuejingfu
 * 2018/8/12.14:55
 */
public class MyOperatorUtil {

    private static final SqlSession sqlSession = MybatisUtil.getInstance();
    private static Logger logger = Logger.getLogger(MyOperatorUtil.class);

    public static List<User> getAllUser() {
        String statement = "userMapper.selectAll";
        return sqlSession.selectList(statement);
    }

    public static int insertUser(User user) {
        String statement = "userMapper.insertUser";
        int insert = sqlSession.insert(statement, user);
        sqlSession.commit();
        return insert;
    }

    public static List<Book> selectBookByUser(User user) {
        logger.info("user's name =" + user.getName());
        String statement = "bookMapper.selectBookByUser";
        return sqlSession.selectList(statement, user);
    }

    public static int insertBook(Book book) {
        String statement = "bookMapper.insertBook";
        int insert = sqlSession.insert(statement, book);
        sqlSession.commit();
        return insert;
    }

}
