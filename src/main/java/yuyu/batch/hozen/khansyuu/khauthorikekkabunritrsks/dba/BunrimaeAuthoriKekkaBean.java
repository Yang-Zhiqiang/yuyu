package yuyu.batch.hozen.khansyuu.khauthorikekkabunritrsks.dba;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 案内収納 分離前オーソリ結果Beanクラス<br />
 */
@AllArgsConstructor
public class BunrimaeAuthoriKekkaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String creditkessaiyouno;

    @Getter @Setter
    private String datajyusinymd;

    @Getter @Setter
    private BizDate syoriYmd;

    @Getter @Setter
    private String kaiintourokukbn;

    @Getter @Setter
    private String creditcardno;

    @Getter @Setter
    private String cardyuukoukigen4keta;

    @Getter @Setter
    private String authorigk7keta;

    @Getter @Setter
    private String authorikekkaerrorcd;

    @Getter @Setter
    private String bluegateerrorcd;

    @Getter @Setter
    private String hisimukekaisyacd;

    @Getter @Setter
    private String wentryuserid;

    @Getter @Setter
    private String errorcomment;

    @Getter @Setter
    private String niniinfo;

    @Getter @Setter
    private String datasyorijyoukyou;

    @Getter @Setter
    private String gyoumuKousinKinou;

    @Getter @Setter
    private String gyoumuKousinsyaId;

    @Getter @Setter
    private String gyoumuKousinTime;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
