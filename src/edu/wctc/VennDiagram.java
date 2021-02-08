package edu.wctc;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class VennDiagram<T> {
    public String circleOneLabel;
    Set<T> circleOneContents = new HashSet<>();

    public String circleTwoLabel;
    Set<T> circleTwoContents = new HashSet<>();

    public String circleThreeLabel;
    Set<T> circleThreeContents = new HashSet<>();

    public VennDiagram(String label1, String label2, String label3) {
        this.circleOneLabel = label1;
        this.circleTwoLabel = label2;
        this.circleThreeLabel = label3;
    }

    public void add(T item, String... labels) {
        for (String label : labels) {
            if (label.equals(this.circleOneLabel)) {
                circleOneContents.add(item);
            } else if (label.equals(this.circleTwoLabel)) {
                circleTwoContents.add(item);
            } else if (label.equals(this.circleThreeLabel)) {
                circleThreeContents.add(item);
            }
        }
    }

    private Set<T> getCircleForLabel(String label) {
        if (label.equals(this.circleOneLabel)) {
            return circleOneContents;
        } else if (label.equals(this.circleTwoLabel)) {
            return circleTwoContents;
        } else if (label.equals(this.circleThreeLabel)) {
            return circleThreeContents;
        }
        return null;
    }

    public Set<T> diagramCenter() {
        Iterator<T> it = circleOneContents.iterator();
        Set<T> centerSet = new HashSet<>();
        while(it.hasNext()){
            T item = it.next();
            if (circleTwoContents.contains(item) && circleThreeContents.contains(item)) {
                centerSet.add(item);
            }
        }
        return centerSet;
    }

    public Set<T> complementOf(String first, String second) {
        Iterator<T> it = getCircleForLabel(first).iterator();
        Set<T> firstNotSecond = new HashSet<>();
        Set<T> secondCircle = getCircleForLabel(second);
        while(it.hasNext()) {
            T item = it.next();
            if (!secondCircle.contains(item)) {
                firstNotSecond.add(item);
            }
        }
        return firstNotSecond;
    }

    public Set<T> unionOf(String first, String second) {
        Iterator<T> it = getCircleForLabel(first).iterator();
        Iterator<T> it2 = getCircleForLabel(second).iterator();
        Set<T> unionCircle = new HashSet<>();
        while(it.hasNext()) {
            unionCircle.add(it.next());
        }
        while(it2.hasNext()) {
            unionCircle.add(it2.next());
        }
        return unionCircle;
    }

    public Set<T> intersectionOf(String first, String second) {
        Iterator<T> it = getCircleForLabel(first).iterator();
        Set<T> firstAndSecond = new HashSet<>();
        Set<T> secondCircle = getCircleForLabel(second);
        while(it.hasNext()) {
            T item = it.next();
            if (secondCircle.contains(item)) {
                firstAndSecond.add(item);
            }
        }
        return firstAndSecond;
    }


}
