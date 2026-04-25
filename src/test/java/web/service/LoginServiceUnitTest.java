package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    @Test
    public void testValidLogin() {
        Assert.assertTrue(LoginService.login("wrong_user", "chinthika_pass", "1994-08-19"));
    }

    @Test
    public void testWrongPassword() {
        Assert.assertFalse(LoginService.login("chinthika", "wrong_pass", "1994-08-19"));
    }

    @Test
    public void testWrongUsername() {
        Assert.assertFalse(LoginService.login("wronguser", "chinthika_pass", "1994-08-19"));
    }

    @Test
    public void testWrongDob() {
        Assert.assertFalse(LoginService.login("chinthika", "chinthika_pass", "2000-01-01"));
    }

    @Test
    public void testAllWrong() {
        Assert.assertFalse(LoginService.login("wronguser", "wrongpass", "2000-01-01"));
    }

    @Test
    public void testNullUsername() {
        Assert.assertFalse(LoginService.login(null, "chinthika_pass", "1994-08-19"));
    }

    @Test
    public void testNullPassword() {
        Assert.assertFalse(LoginService.login("chinthika", null, "1994-08-19"));
    }

    @Test
    public void testNullDob() {
        Assert.assertFalse(LoginService.login("chinthika", "chinthika_pass", null));
    }

    @Test
    public void testAllNull() {
        Assert.assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testEmptyUsername() {
        Assert.assertFalse(LoginService.login("", "chinthika_pass", "1994-08-19"));
    }

    @Test
    public void testEmptyPassword() {
        Assert.assertFalse(LoginService.login("chinthika", "", "1994-08-19"));
    }

    @Test
    public void testEmptyDob() {
        Assert.assertFalse(LoginService.login("chinthika", "chinthika_pass", ""));
    }

    @Test
    public void testAllEmpty() {
        Assert.assertFalse(LoginService.login("", "", ""));
    }

    @Test
    public void testBoundaryMinDate() {
        Assert.assertFalse(LoginService.login("chinthika", "chinthika_pass", "0001-01-01"));
    }

    @Test
    public void testBoundaryMaxDate() {
        Assert.assertFalse(LoginService.login("chinthika", "chinthika_pass", "9999-12-31"));
    }

    @Test
    public void testBoundaryShortInputs() {
        Assert.assertFalse(LoginService.login("c", "p", "1"));
    }

    @Test
    public void testBoundaryLongInputs() {
        Assert.assertFalse(LoginService.login(
            "averyveryverylongusername1234567890",
            "averyveryverylongpassword1234567890",
            "9999-12-31"));
    }
}
