package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_BAK_SyuunouHenknRireki;


/**
 * 収納返金履歴バックアップテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_BAK_SyuunouHenknRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_BAK_SyuunouHenknRireki<br />
 * @see     PKIT_BAK_SyuunouHenknRireki<br />
 * @see     QIT_BAK_SyuunouHenknRireki<br />
 * @see     GenQIT_BAK_SyuunouHenknRireki<br />
 */
@Entity
public class IT_BAK_SyuunouHenknRireki extends GenIT_BAK_SyuunouHenknRireki {

    private static final long serialVersionUID = 1L;

    public IT_BAK_SyuunouHenknRireki() {
    }

    public IT_BAK_SyuunouHenknRireki(String pKbnkey,String pSyono,String pTrkssikibetukey,String pDenrenno,Integer pEdano) {
        super(pKbnkey,pSyono,pTrkssikibetukey,pDenrenno,pEdano);
    }

    public IT_BAK_SyuunouHenknRireki(String pSyono,String pTrkssikibetukey,String pDenrenno,Integer pEdano) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pTrkssikibetukey,pDenrenno,pEdano);
    }


    private IT_BAK_AnsyuKihon iT_BAKAnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_BAK_SyuunouHenknRireki.KBNKEY  , referencedColumnName=IT_BAK_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_SyuunouHenknRireki.SYONO  , referencedColumnName=IT_BAK_AnsyuKihon.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=IT_BAK_SyuunouHenknRireki.TRKSSIKIBETUKEY  , referencedColumnName=IT_BAK_AnsyuKihon.TRKSSIKIBETUKEY, insertable=false, updatable=false)
    })
    public IT_BAK_AnsyuKihon getBAKAnsyuKihon() {
        return iT_BAKAnsyuKihon;
    }

    public void setBAKAnsyuKihon(IT_BAK_AnsyuKihon pIT_BAK_AnsyuKihon) {
        this.iT_BAKAnsyuKihon = pIT_BAK_AnsyuKihon;
    }

}

