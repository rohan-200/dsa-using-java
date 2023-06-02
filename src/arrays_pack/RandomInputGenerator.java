package arrays_pack;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

public class RandomInputGenerator<T> {
    Random random = new Random();

    public String getAlphaNumericString(int n) {
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomString
                = new String(array, Charset.forName("UTF-8"));

        StringBuffer r = new StringBuffer();


        for (int k = 0; k < randomString.length(); k++) {

            char ch = randomString.charAt(k);

            if (((ch >= 'a' && ch <= 'z')
                    || (ch >= 'A' && ch <= 'Z')
                    || (ch >= '0' && ch <= '9'))
                    && (n > 0)) {

                r.append(ch);
                n--;
            }
        }
        return r.toString();
    }

    public String[] stringArray(int len) {
        String[] arr = null;
        for (int i = 0; i < len; i++) {
            arr[i] = this.getAlphaNumericString(random.nextInt(i));
        }
        return arr;
    }
    public List<String> stringArrayList(int len) {
        List<String> arr = null;
        for (int i = 0; i < len; i++) {
            arr.set(i,this.getAlphaNumericString(random.nextInt(i)));
        }
        return arr;
    }
}
