package com.example.dondeQueda.services;

import com.example.dondeQueda.models.*;
import com.example.dondeQueda.repositories.*;
import com.example.dondeQueda.services.interfaces.IEntityValidatorService;
import org.springframework.stereotype.Service;

@Service
public class EntityValidatorService implements IEntityValidatorService {

  private final IAddressRepository addressRepo;
  private final ICategoryRepository categoryRepo;
  private final ICommerceRepository commerceRepo;
  private final IEventRepository eventRepo;
  private final IImageRepository imageRepo;
  private final IPostRepository postRepo;
  private final IScheduleRepository scheduleRepo;
  private final ISubcategoryRepository subcategoryRepo;
  private final ISubscriptionRepository subscriptionRepo;
  private final ITagRepository tagRepo;
  private final IUserRepository userRepo;

  public EntityValidatorService(
      IAddressRepository addressRepo,
      ICategoryRepository categoryRepo,
      ICommerceRepository commerceRepo,
      IEventRepository eventRepo,
      IImageRepository imageRepo,
      IPostRepository postRepo,
      IScheduleRepository scheduleRepo,
      ISubcategoryRepository subcategoryRepo,
      ISubscriptionRepository subscriptionRepo,
      ITagRepository tagRepo,
      IUserRepository userRepo) {
    this.addressRepo = addressRepo;
    this.categoryRepo = categoryRepo;
    this.commerceRepo = commerceRepo;
    this.eventRepo = eventRepo;
    this.imageRepo = imageRepo;
    this.postRepo = postRepo;
    this.scheduleRepo = scheduleRepo;
    this.subcategoryRepo = subcategoryRepo;
    this.subscriptionRepo = subscriptionRepo;
    this.tagRepo = tagRepo;
    this.userRepo = userRepo;
  }

  @Override
  public Address validateAddress(Long idAddress) {
    return addressRepo
        .findById(idAddress)
        .orElseThrow(
            () -> new RuntimeException("Dirección con ID '" + idAddress + "' no encontrada."));
  }

  @Override
  public Category validateCategory(Long idCategory) {
    return categoryRepo
        .findById(idCategory)
        .orElseThrow(
            () -> new RuntimeException("Categoría con ID '" + idCategory + "' no encontrada."));
  }

  @Override
  public Commerce validateCommerce(Long idCommerce) {
    return commerceRepo
        .findById(idCommerce)
        .orElseThrow(
            () -> new RuntimeException("Comercio con ID '" + idCommerce + "' no encontrado."));
  }

  @Override
  public Event validateEvent(Long idEvent) {
    return eventRepo
        .findById(idEvent)
        .orElseThrow(() -> new RuntimeException("Evento con ID '" + idEvent + "' no encontrado."));
  }

  @Override
  public Image validateImage(Long idImage) {
    return imageRepo
        .findById(idImage)
        .orElseThrow(() -> new RuntimeException("Imagen con ID '" + idImage + "' no encontrada."));
  }

  @Override
  public Post validatePost(Long idPost) {
    return postRepo
        .findById(idPost)
        .orElseThrow(
            () -> new RuntimeException("Publicación con ID '" + idPost + "' no encontrada."));
  }

  @Override
  public Schedule validateSchedule(Long idSchedule) {
    return scheduleRepo
        .findById(idSchedule)
        .orElseThrow(
            () -> new RuntimeException("Horario con ID '" + idSchedule + "' no encontrado."));
  }

  @Override
  public Subcategory validateSubcategory(Long idSubcategory) {
    return subcategoryRepo
        .findById(idSubcategory)
        .orElseThrow(
            () ->
                new RuntimeException("Subcategoría con ID '" + idSubcategory + "' no encontrada."));
  }

  @Override
  public Subscription validateSubscription(Long idSubscription) {
    return subscriptionRepo
        .findById(idSubscription)
        .orElseThrow(
            () ->
                new RuntimeException(
                    "Subscripción con ID '" + idSubscription + "' no encontrada."));
  }

  @Override
  public Tag validateTag(Long idTag) {
    return tagRepo
        .findById(idTag)
        .orElseThrow(() -> new RuntimeException("Etiqueta con ID '" + idTag + "' no encontrada."));
  }

  @Override
  public User validateUser(Long idUser) {
    return userRepo
        .findById(idUser)
        .orElseThrow(() -> new RuntimeException("Usuario con ID '" + idUser + "' no encontrado."));
  }
}
