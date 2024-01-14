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

    private String isEnabled;
    private String isLikeOrReactionOnPhotosEnabled;
    private String isCommentOnPostsEnabled;
    private String isSharingOnPostsEnabled;
    private String isTaggingEnabled;
    private String isCoinsAndBadgesEnabled;
    private String isEventsOrRidesEnabled;
    private String isRoleChangesEnabled;
    private String isCommunityUpdatesEnabled;

    // Constructors, getters, setters
}

