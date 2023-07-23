package yuyu.infr.exception;

import java.io.Serializable;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import jp.co.slcs.swak.bizinfr.exception.BizException;
import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.util.ExceptionUtil;
import jp.co.slcs.swak.util.message.MessageBuilder;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.ExceptionMessages;
import jp.co.slcs.swak.web.pages.ExceptionHandler;
import lombok.Getter;
import lombok.Setter;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.configuration.ExceptionMessage;
import yuyu.def.base.configuration.YuyuBaseConfig;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.base.Supplier;
import com.google.common.collect.Iterables;
import com.google.inject.servlet.RequestScoped;

/**
 * 例外ハンドラです。<br />
 */
@SuppressWarnings("deprecation")
public class ExceptionMessageHandler implements ExceptionHandler<Exception> {

    static final Logger log = LoggerFactory.getLogger(ExceptionMessageHandler.class);

    private static final String OTHER_EXCEPTION = "otherException";

    static Supplier<ExceptionMessage> otherExceptionMessageSupplier = new Supplier<ExceptionMessage>() {
        @Override
        public ExceptionMessage get() {
            return Iterables.find(
                YuyuBaseConfig.getInstance().getExceptionMessageList(),
                new Predicate<ExceptionMessage>() {
                    @Override
                    public boolean apply(ExceptionMessage msg) {
                        return msg.getException().equals(OTHER_EXCEPTION);
                    }
                }
                );
        }
    };

    @RequestScoped
    public static class GlobalErrorTitle implements Serializable {

        private static final long serialVersionUID = -8806113429851890870L;

        @Getter @Setter
        private String titleId;

        public String getTitle() {

            if (Strings.isNullOrEmpty(getTitleId())) {
                ExceptionMessages messages = SWAKInjector.getInstance(ExceptionMessages.class);

                String otherExceptionMessage = MessageUtil.getMessage(otherExceptionMessageSupplier.get().getMessageId());
                String otherExceptionTitle = MessageUtil.getMessage(otherExceptionMessageSupplier.get().getTitleId());

                if (Strings.isNullOrEmpty(messages.iterator().next().toString())) {
                    return "";
                }

                if (otherExceptionMessage.equals(messages.iterator().next())) {
                    return otherExceptionTitle;
                }

                return MessageUtil.getMessage(MessageId.IAS0013);

            }

            return MessageUtil.getMessage(getTitleId());

        }
    }


    @Override
    public String handle(final Exception exception) {
        ExceptionMessage exMsg = Iterables.tryFind(
            YuyuBaseConfig.getInstance().getExceptionMessageList(),
            new Predicate<ExceptionMessage>() {
                @Override
                public boolean apply(ExceptionMessage msg) {
                    if (msg.getException().equals("otherException")) {
                        return false;
                    }
                    Class<?> exClass;
                    try {
                        exClass = Class.forName(msg.getException());
                    } catch (ClassNotFoundException e) {
                        log.info("ClassNotFound. (class={})", e.getMessage());
                        return false;
                    }
                    return exception.getClass().equals(exClass);
                }
            }
            ).or(
                otherExceptionMessageSupplier
                );

        SWAKInjector.getInstance(GlobalErrorTitle.class).setTitleId(exMsg.getTitleId());

        ExceptionMessages errorMessages = SWAKInjector.getInstance(ExceptionMessages.class);
        if (! Strings.isNullOrEmpty(exMsg.getMessageId())) {
            if (exception instanceof BizException) {
                BizException bizEx = (BizException) exception;
                if (exMsg.getException().equals("otherException")) {
                    errorMessages.add(
                        new Message(
                            Message.DEFAULT_GROUP,
                            null,
                            exMsg.getMessageId(),
                            Message.NO_ROW_NUMBER,
                            Message.EMPTY_ITEMS,
                            null
                            )
                        );
                    for (Message message : bizEx.getMessages()) {
                        errorMessages.add(
                            new Message(
                                Message.DEFAULT_GROUP,
                                null,
                                message.getMessageId(),
                                Message.NO_ROW_NUMBER,
                                Message.EMPTY_ITEMS,
                                message.getMessageArgs()
                                )
                            );
                    }
                } else {
                    for (Message message : bizEx.getMessages()) {
                        errorMessages.add(
                            new Message(
                                Message.DEFAULT_GROUP,
                                null,
                                exMsg.getMessageId(),
                                Message.NO_ROW_NUMBER,
                                Message.EMPTY_ITEMS,
                                message.getMessageArgs()
                                )
                            );
                    }
                }
            } else {
                errorMessages.add(
                    new Message(
                        Message.DEFAULT_GROUP,
                        null,
                        exMsg.getMessageId(),
                        Message.NO_ROW_NUMBER,
                        Message.EMPTY_ITEMS,
                        null
                        )
                    );
                if (YuyuBaseConfig.getInstance().isDebugMode()) {
                    for (Throwable t : ExceptionUtil.getCauses(exception)) {
                        if (t instanceof ConstraintViolationException) {
                            ConstraintViolationException cve = (ConstraintViolationException) t;
                            for (ConstraintViolation<?> cv : cve.getConstraintViolations()) {
                                errorMessages.add(
                                    new Message(
                                        Message.DEFAULT_GROUP,
                                        "(" + cv.getLeafBean().getClass().getSimpleName() + ") " + SWAKInjector.getInstance(MessageBuilder.class).buildMessage(cv),
                                        null,
                                        Message.NO_ROW_NUMBER,
                                        Message.EMPTY_ITEMS,
                                        null
                                    )
                                );
                            }
                        } else {
                            if (! Strings.isNullOrEmpty(t.getMessage())) {
                                errorMessages.add(
                                    new Message(
                                        Message.DEFAULT_GROUP,
                                        t.getMessage(),
                                        null,
                                        Message.NO_ROW_NUMBER,
                                        Message.EMPTY_ITEMS,
                                        null
                                    )
                                );
                            }
                        }
                    }
                }
            }
        } else {
            if (exception instanceof BizException) {
                BizException bizEx = (BizException) exception;
                errorMessages.addAll(bizEx.getMessages());
            } else {
                errorMessages.add(
                    new Message(
                        Message.DEFAULT_GROUP,
                        exception.getMessage(),
                        null,
                        Message.NO_ROW_NUMBER,
                        Message.EMPTY_ITEMS,
                        null
                        )
                    );
            }
        }
        return null;
    }
}
