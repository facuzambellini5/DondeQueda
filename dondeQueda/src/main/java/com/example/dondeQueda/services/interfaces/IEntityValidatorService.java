package com.example.dondeQueda.services.interfaces;

import com.example.dondeQueda.models.*;

public interface IEntityValidatorService {

    Address validateAddress (Long idAddress);
    Category validateCategory (Long idCategory);
    Commerce validateCommerce (Long idCommerce);
    Event validateEvent (Long idEvent);
    Image validateImage (Long idImage);
    Post validatePost (Long idPost);
    Schedule validateSchedule (Long idSchedule);
    Subcategory validateSubcategory (Long idSubcategory);
    Subscription validateSubscription (Long idSubscription);
    Tag validateTag (Long idTag);
    User validateUser (Long idUser);
}
