
package com.example.chenduo.cdtemplate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine
 * (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void dbTest() throws Exception {
        // UserDao dao =
        // GreenDaoUtils.getInstance().getmDaoSession().getUserDao();
        // for (int i = 0; i < 5; i++) {
        // User u = new User();
        // u.setName("test" + i);
        // dao.insert(u);
        // }
        // List<User> list = dao.loadAll();
        // assertEquals(5, list.size());
    }
}
