package SimHashTest;

/**
 * testSimHash
 */
public class testSimHash {

    public static void main(String[] args) {

        String str1 = "she is a good girl, I really like her";
        String str2 = "a good girl is she, I really like her";
        SimHash sHash = new SimHash();
        long hash1 = sHash.simhash32(str1);
        long hash2 = sHash.simhash32(str2);
        System.out.println(Long.toBinaryString(hash1));
        System.out.println(Long.toBinaryString(hash2));
        int value = sHash.hammingDistance(hash1, hash2);
        System.out.println("The hamming Distance is " + value);

    }

}