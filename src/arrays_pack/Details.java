package arrays_pack;

public class Details {
    Integer index;
    Boolean isFound;

    public Details(Integer index,Boolean isFound) {
        this.index = index;
        this.isFound = isFound;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getFound() {
        return isFound;
    }

    public void setFound(Boolean found) {
        isFound = found;
    }

    @Override
    public String toString() {
        if(isFound)
            return "{" +"index=" + index +", isFound=" + isFound +'}';
        else
            return "Not Found";
    }
}
