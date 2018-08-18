package base.entity;

import java.util.Comparator;

public class DocumentUnit {
<<<<<<< HEAD
=======
    public static final Comparator<DocumentUnit> COMPARE_BY_SIZE = new Comparator<DocumentUnit>() {

        @Override
        public int compare(DocumentUnit o1, DocumentUnit o2) {
            return Integer.compare(o1.size, o2.size);
        }
    };
    public static final Comparator<DocumentUnit> COMPARE_BY_DURATION = new Comparator<DocumentUnit>() {
        @Override
        public int compare(DocumentUnit o1, DocumentUnit o2) {
            return Integer.compare(o1.duration, o2.duration);
        }
    };
    public static final Comparator<DocumentUnit> COMPARE_BY_TYPE = new Comparator<DocumentUnit>() {
        @Override
        public int compare(DocumentUnit o1, DocumentUnit o2) {
            return o1.descr.compareTo(o2.descr);
        }
    };
>>>>>>> 3 commit
    private String name;
    private String descr;
    private int duration;
    private int size;

    public DocumentUnit(String name, String descr, int duration, int size) {
        this.name = name;
        this.descr = descr;
        this.duration = duration;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "DocumentUnit{" +
                "name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                ", duration=" + duration +
                ", size=" + size +
                '}';
    }
<<<<<<< HEAD

    public static final Comparator<DocumentUnit> COMPARE_BY_SIZE = new Comparator<DocumentUnit>() {

        @Override
        public int compare(DocumentUnit o1, DocumentUnit o2) {

            return o1.size-o2.size;
        }
    };
    public static final Comparator<DocumentUnit> COMPARE_BY_DURATION = new Comparator<DocumentUnit>() {

        @Override
        public int compare(DocumentUnit o1, DocumentUnit o2) {

            return o1.duration-o2.duration;
        }
    };

    public static final Comparator<DocumentUnit> COMPARE_BY_TYPE = new Comparator<DocumentUnit>() {

        @Override
        public int compare(DocumentUnit o1, DocumentUnit o2) {

            return o1.descr.compareTo(o2.descr);
        }
    };
=======
>>>>>>> 3 commit
}