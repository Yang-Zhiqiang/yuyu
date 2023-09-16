package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.mapping.GenIT_BAK_KhLincSousinInfo;


/**
 * 契約保全ＬＩＮＣ送信情報バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhLincSousinInfo} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhLincSousinInfo<br />
 * @see     PKIT_BAK_KhLincSousinInfo<br />
 * @see     QIT_BAK_KhLincSousinInfo<br />
 * @see     GenQIT_BAK_KhLincSousinInfo<br />
 */
@Entity
public class IT_BAK_KhLincSousinInfo extends GenIT_BAK_KhLincSousinInfo {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhLincSousinInfo() {
    }

    public IT_BAK_KhLincSousinInfo(String pKbnkey,C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,String pTrkssikibetukey,String pSyono,Integer pRenno) {
        super(pKbnkey,pLincsoujyusinsyskbn,pTrkssikibetukey,pSyono,pRenno);
    }

    public IT_BAK_KhLincSousinInfo(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,String pTrkssikibetukey,String pSyono,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pLincsoujyusinsyskbn,pTrkssikibetukey,pSyono,pRenno);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhLincSousinInfo.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhLincSousinInfo.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhLincSousinInfo.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

