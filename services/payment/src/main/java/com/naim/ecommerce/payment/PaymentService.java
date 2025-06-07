package com.naim.ecommerce.payment;

import com.naim.ecommerce.notification.NotificationProducer;
import com.naim.ecommerce.notification.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  private final PaymentRepository repository;
  private final PaymentMapper mapper;
  private final NotificationProducer notificationProducer;


  public PaymentService(PaymentRepository repository, PaymentMapper mapper, NotificationProducer notificationProducer) {
    this.repository = repository;
    this.mapper = mapper;
    this.notificationProducer = notificationProducer;
  }
  public Integer createPayment(PaymentRequest request) {
    var payment = this.repository.save(this.mapper.toPayment(request));

    this.notificationProducer.sendNotification(
            new PaymentNotificationRequest(
                    request.orderReference(),
                    request.amount(),
                    request.paymentMethod(),
                    request.customer().firstname(),
                    request.customer().lastname(),
                    request.customer().email()
            )
    );
    return payment.getId();
  }
}
