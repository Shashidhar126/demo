package com.example.demo.payload;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityNotificationDTO {

    private Boolean isEnabled;
    private Boolean isLikeOrReactionOnPhotosEnabled;
    private Boolean isCommentOnPostsEnabled;
    private Boolean isSharingOnPostsEnabled;
    private Boolean isTaggingEnabled;
    private Boolean isCoinsAndBadgesEnabled;
    private Boolean isEventsOrRidesEnabled;
    private Boolean isRoleChangesEnabled;
    private Boolean isCommunityUpdatesEnabled;
}
