package ex06_likeIt_OBF;

public class LikeItSimple {

    public String display(String[] name) {
        if (name == null) return "";

        int numberOfNames = name.length;

        if (numberOfNames == 0)
            return "no one likes this :-(";
        if (numberOfNames == 1) {
            return name[0] + " likes this";
        }
        if (numberOfNames == 2) {
            return name[0] + " and " + name[1] + " like this";
        }
        if (numberOfNames == 3) {
            return String.format("%s, %s and %s", name[0], name[1], name[2]) + " like this";
        }

        return String.format("%s, %s and %d others like this", name[0], name[1], numberOfNames - 2);
    }
}
