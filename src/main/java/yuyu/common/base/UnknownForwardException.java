package yuyu.common.base;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import yuyu.def.MessageId;

/**
 * フォワード先不明時の例外です。
 */
public class UnknownForwardException extends BizAppException {

    private static final long serialVersionUID = 20140001L;

   public UnknownForwardException() {
       this(MessageId.EAC0015);
   }

   private UnknownForwardException(String pMessageId) {
       super(pMessageId);
   }
}
