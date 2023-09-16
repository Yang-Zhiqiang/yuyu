package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_KhShrRirekiDetail;


/**
 * 契約保全支払履歴明細テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhShrRirekiDetail} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhShrRirekiDetail<br />
 * @see     PKIT_KhShrRirekiDetail<br />
 * @see     QIT_KhShrRirekiDetail<br />
 * @see     GenQIT_KhShrRirekiDetail<br />
 */
@Entity
public class IT_KhShrRirekiDetail extends GenIT_KhShrRirekiDetail {

    private static final long serialVersionUID = 1L;

    public IT_KhShrRirekiDetail() {
    }

    public IT_KhShrRirekiDetail(String pKbnkey,String pSyono,String pHenkousikibetukey,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(pKbnkey,pSyono,pHenkousikibetukey,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }

    public IT_KhShrRirekiDetail(String pSyono,String pHenkousikibetukey,String pSyouhncd,Integer pSyouhnsdno,Integer pKyksyouhnrenno) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pHenkousikibetukey,pSyouhncd,pSyouhnsdno,pKyksyouhnrenno);
    }


    private IT_KhShrRireki iT_KhShrRireki ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_KhShrRirekiDetail.KBNKEY  , referencedColumnName=IT_KhShrRireki.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhShrRirekiDetail.SYONO  , referencedColumnName=IT_KhShrRireki.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_KhShrRirekiDetail.HENKOUSIKIBETUKEY  , referencedColumnName=IT_KhShrRireki.HENKOUSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_KhShrRireki getKhShrRireki() {
        return iT_KhShrRireki;
    }

    public void setKhShrRireki(IT_KhShrRireki pIT_KhShrRireki) {
        this.iT_KhShrRireki = pIT_KhShrRireki;
    }

}

