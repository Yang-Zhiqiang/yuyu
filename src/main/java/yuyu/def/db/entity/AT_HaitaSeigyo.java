package yuyu.def.db.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import yuyu.def.db.id.PKAT_HaitaSeigyo;
import yuyu.def.db.mapping.GenAT_HaitaSeigyo;
import yuyu.def.db.meta.GenQAT_HaitaSeigyo;
import yuyu.def.db.meta.QAT_HaitaSeigyo;

/**
 * 排他制御テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_HaitaSeigyo} の JavaDoc を参照してください。
 * @see     GenAT_HaitaSeigyo
 * @see     PKAT_HaitaSeigyo
 * @see     QAT_HaitaSeigyo
 * @see     GenQAT_HaitaSeigyo
 */
@Entity
public class AT_HaitaSeigyo extends GenAT_HaitaSeigyo {

    private static final long serialVersionUID = 1L;

    public AT_HaitaSeigyo() {
    }

    public AT_HaitaSeigyo(String pHaitaSyuruiCd, String pHaitaKey) {
        super(pHaitaSyuruiCd, pHaitaKey);
    }


    private AM_HaitaSyurui aM_HaitaSyurui;

    @LazyToOne(LazyToOneOption.FALSE)
    @ManyToOne
    @JoinColumn(name=AT_HaitaSeigyo.HAITASYURUICD, referencedColumnName=AM_HaitaSyurui.HAITASYURUICD, insertable=false, updatable=false)
    public AM_HaitaSyurui getHaitaSyurui() {
        return aM_HaitaSyurui;
    }

    public void setHaitaSyurui(AM_HaitaSyurui pHaitaSyurui) {
        aM_HaitaSyurui = pHaitaSyurui;
    }

}
