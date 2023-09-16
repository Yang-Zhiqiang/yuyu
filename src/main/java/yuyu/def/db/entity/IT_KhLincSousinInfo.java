package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.mapping.GenIT_KhLincSousinInfo;


/**
 * 契約保全ＬＩＮＣ送信情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhLincSousinInfo} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhLincSousinInfo<br />
 * @see     PKIT_KhLincSousinInfo<br />
 * @see     QIT_KhLincSousinInfo<br />
 * @see     GenQIT_KhLincSousinInfo<br />
 */
@Entity
public class IT_KhLincSousinInfo extends GenIT_KhLincSousinInfo {

    private static final long serialVersionUID = 1L;

    public IT_KhLincSousinInfo() {
    }

    public IT_KhLincSousinInfo(String pKbnkey,C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,String pSyono,Integer pRenno) {
        super(pKbnkey,pLincsoujyusinsyskbn,pSyono,pRenno);
    }

    public IT_KhLincSousinInfo(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,String pSyono,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pLincsoujyusinsyskbn,pSyono,pRenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhLincSousinInfo.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhLincSousinInfo.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

