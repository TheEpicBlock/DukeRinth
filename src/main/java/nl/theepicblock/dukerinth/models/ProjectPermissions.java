package nl.theepicblock.dukerinth.models;

public class ProjectPermissions {
    public static final int UPLOAD_VERSION = 0x0001;
    public static final int DELETE_VERSION = 0x0002;
    public static final int EDIT_DETAILS = 0x0004;
    public static final int EDIT_BODY = 0x0008;
    public static final int MANAGE_INVITES = 0x0010;
    public static final int REMOVE_MEMBER = 0x0020;
    public static final int EDIT_MEMBER = 0x0040;
    public static final int DELETE_PROJECT = 0x0080;
    public static final int VIEW_ANALYTICS = 0x0100;
    public static final int VIEW_PAYOUTS = 0x0200;
}
