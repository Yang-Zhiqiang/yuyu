package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhLincSousinData;


/**
 * 契約保全ＬＩＮＣ送信データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhLincSousinData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhLincSousinData<br />
 * @see     PKIT_KhLincSousinData<br />
 * @see     QIT_KhLincSousinData<br />
 * @see     GenQIT_KhLincSousinData<br />
 */
@Entity
public class IT_KhLincSousinData extends GenIT_KhLincSousinData {

    private static final long serialVersionUID = 1L;

    public IT_KhLincSousinData() {
    }

    public IT_KhLincSousinData(String pKbnkey,String pSyono,BizDate pSyoriYmd,Integer pRenno) {
        super(pKbnkey,pSyono,pSyoriYmd,pRenno);
    }

    public IT_KhLincSousinData(String pSyono,BizDate pSyoriYmd,Integer pRenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pSyoriYmd,pRenno);
    }


    private IT_KykKihon iT_KykKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhLincSousinData.KBNKEY  , referencedColumnName=IT_KykKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhLincSousinData.SYONO  , referencedColumnName=IT_KykKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_KykKihon getKykKihon() {
        return iT_KykKihon;
    }

    public void setKykKihon(IT_KykKihon pIT_KykKihon) {
        this.iT_KykKihon = pIT_KykKihon;
    }

}

