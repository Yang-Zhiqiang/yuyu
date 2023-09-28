package yuyu.common.base;

import java.io.Serializable;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import lombok.Data;
import yuyu.def.enumeration.E_SyoriKbn;

/**
 * カンバセーションに保持するステータスを管理するユーティリティクラスです。
 */
@Data
@ConversationScoped
public class ConversationStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    private E_SyoriKbn syoriKbn;
}
