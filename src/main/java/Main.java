import bean.Book;
import bean.User;
import org.apache.log4j.Logger;
import utils.MyOperatorUtil;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by xuejingfu
 * 2018/8/12.15:01
 */
public class Main {

    private static final int CORE_POOL_SIZE = 10;

    public static void main(String[] args) {
        List<User> allUser = MyOperatorUtil.getAllUser();
        int size = allUser.size();
        int batch = 1;

        ExecutorService pool = new ThreadPoolExecutor(CORE_POOL_SIZE, CORE_POOL_SIZE, 0, TimeUnit.MILLISECONDS
                , new ArrayBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.CallerRunsPolicy());
        int start = 0;
        while (start + batch < size) {
            pool.submit(new MultiSearch(allUser, start, start + batch));
            start += batch;
        }
        pool.submit(new MultiSearch(allUser, start, size));
        pool.shutdown();
    }
}

class MultiSearch implements Callable, Serializable {
    private static Logger logger = Logger.getLogger(MultiSearch.class);
    private List<User> userList;
    private int start;
    private int end;

    public MultiSearch() {
    }

    public MultiSearch(List<User> userList, int start, int end) {
        this.userList = userList;
        this.start = start;
        this.end = end;
    }

    public Object call() throws Exception {
        logger.info("call:" + start + "--" + end);
        while (start < end) {
            User user = userList.get(start);

            List<Book> books = MyOperatorUtil.selectBookByUser(user);
            logger.info(books);

            start++;
        }

        return null;
    }
}

