package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommunityNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean isEnabled;
    private Boolean isLikeOrReactionOnPhotosEnabled;
    private Boolean isCommentOnPostsEnabled;
    private Boolean isSharingOnPostsEnabled;
    private Boolean isTaggingEnabled;
    private Boolean isCoinsAndBadgesEnabled;
    private Boolean isEventsOrRidesEnabled;
    private Boolean isRoleChangesEnabled;
    private Boolean isCommunityUpdatesEnabled;

    // Constructors, getters, setters
}


