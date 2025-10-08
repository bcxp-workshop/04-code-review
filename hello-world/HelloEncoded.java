public class HelloEncoded {

    public static void main(String[] args) {
        String word = "Hello World!";
        String spoon = encode(word);
        System.out.println(spoon);
    }

    public static String encode(String input) {
        String l = "";
        for (int q = 0; q < input.length(); q++) {
            char c = input.charAt(q);

            boolean isV = false;
            switch ((c+"").toLowerCase()) {
                case "a": isV=true; break;
                case "e": isV=true; break;
                case "i": isV=true; break;
                case "o": isV=true; break;
                case "u": isV=true; break;
                case "ä": isV=true; break;
                case "ö": isV=true; break;
                case "ü": isV=true; break;
            }

            String z = c+"";
            if (isV) {
                String add = "";
                for (int x=0; x<z.length(); x++) {
                    add += z.charAt(x);
                }
                l += add + "lew" + add;
            } else {
                l += z;
            }
        }
        l = l.replace("  ", " ");
        return l;
    }
}