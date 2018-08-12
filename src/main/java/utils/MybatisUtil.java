package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by xuejingfu
 * 2018/8/12.14:45
 */
public class MybatisUtil {
    private static SqlSession sqlSession;

    public static SqlSession getInstance() {
        if (sqlSession == null) {
            String resource = "mybatis-config.xml";

            Reader reader = null;
            try {
                reader = Resources.getResourceAsReader(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }

            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = factory.openSession();

        }
        return sqlSession;
    }

}
