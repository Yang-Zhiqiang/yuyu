package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_KhLincSousinData;


/**
 * 契約保全ＬＩＮＣ送信データバックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_KhLincSousinData} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_KhLincSousinData<br />
 * @see     PKIT_BAK_KhLincSousinData<br />
 * @see     QIT_BAK_KhLincSousinData<br />
 * @see     GenQIT_BAK_KhLincSousinData<br />
 */
@Entity
public class IT_BAK_KhLincSousinData extends GenIT_BAK_KhLincSousinData {

    private static final long serialVersionUID = 1L;

    public IT_BAK_KhLincSousinData() {
    }

    public IT_BAK_KhLincSousinData(String pKbnkey,String pSyono,String pTrkssikibetukey,BizDate pSyoriYmd,Integer pRenno) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pSyoriYmd,pRenno);
    }

    public IT_BAK_KhLincSousinData(String pSyono,String pTrkssikibetukey,BizDate pSyoriYmd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pSyoriYmd,pRenno);
    }


    private IT_BAK_KykKihon iT_BAKKykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_KhLincSousinData.KBNKEY  , referencedColumnName=IT_BAK_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhLincSousinData.SYONO  , referencedColumnName=IT_BAK_KykKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_KhLincSousinData.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_KykKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_KykKihon getBAKKykKihon() {
        return iT_BAKKykKihon;
    }

    public void setBAKKykKihon(IT_BAK_KykKihon pIT_BAK_KykKihon) {
        this.iT_BAKKykKihon = pIT_BAK_KykKihon;
    }

}

