public class Reviews {
    private User user;
    private int rating;
    private String comment;

    public Reviews(User user, int rating, String comment) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public void showReview() {
        System.out.println(user.getNickname() + " rated: " + rating + "/5");
        System.out.println("Comment: " + comment);
    }
}
