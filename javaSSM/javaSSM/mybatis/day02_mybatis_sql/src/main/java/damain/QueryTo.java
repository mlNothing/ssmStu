package damain;

import java.util.List;

public class QueryTo {
    private user user;
    private List<Integer> ads;

    public List<Integer> getAds() {
        return ads;
    }

    public void setAds(List<Integer> ads) {
        this.ads = ads;
    }

    public QueryTo() {
    }

    public damain.user getUser() {
        return user;
    }

    public void setUser(damain.user user) {
        this.user = user;
    }

}
