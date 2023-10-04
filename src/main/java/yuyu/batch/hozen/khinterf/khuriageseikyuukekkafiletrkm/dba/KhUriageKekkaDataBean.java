package yuyu.batch.hozen.khinterf.khuriageseikyuukekkafiletrkm.dba;

import java.io.Serializable;

import jp.co.slcs.swak.util.bean.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 売上請求結果F取込を保持するBeanクラス <br />
 */
@AllArgsConstructor
public class KhUriageKekkaDataBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String ztrrecordkbn;

    @Getter
    @Setter
    private String ztrauthorikbn;

    @Getter
    @Setter
    private String ztruriageseikyuutorihikicd;

    @Getter
    @Setter
    private String ztruriagetaisyouym;

    @Getter
    @Setter
    private String ztruriageymd6keta;

    @Getter
    @Setter
    private String ztrcreditkigyoucd;

    @Getter
    @Setter
    private String ztrcreditkessaiyouno;

    @Getter
    @Setter
    private String ztrsyono;

    @Getter
    @Setter
    private String ztrrecordno;

    @Getter
    @Setter
    private String ztrcardyuukoukigen;

    @Getter
    @Setter
    private Long ztrseikyuukngk;

    @Getter
    @Setter
    private String ztrcreditkaiinnokami6keta;

    @Getter
    @Setter
    private String ztrcreditkaiinnosimo4keta;

    @Getter
    @Setter
    private String ztruriageseikyuuerrorcd;

    @Getter
    @Setter
    private String ztrhurikaekekkacd;

    @Getter
    @Setter
    private String ztrfukusuukameitennokey;

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }
}
