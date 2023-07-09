CREATE TABLE MT_DsTourokuUkKouzaAnsyono (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     dsttdksyubetukbn                                   VARCHAR     (2)                                                       NOT NULL  ,  /* ＤＳ手続種別区分 */
     datarenno                                          NUMBER      (5)                                                       NOT NULL  ,  /* データ連番 */
     kzsyuruikbn                                        VARCHAR     (1)                                                                 ,  /* 口座種類区分 */
     soukinkzyennrkumu                                  VARCHAR     (1)                                                                 ,  /* 送金用口座（円貨）入力有無 */
     tokuteitrhkansyononrkumu                           VARCHAR     (1)                                                                 ,  /* 特定取引用暗証番号入力有無 */
     dstrhkserviceknykeironrumu                         VARCHAR     (1)                                                                 ,  /* ＤＳ取引サービス加入経路入力有無 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzdoukbn                                           VARCHAR     (1)                                                                 ,  /* 口座名義人同一区分 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     tokuteitrhkansyono                                 VARCHAR     (24)                                                                ,  /* 特定取引用暗証番号 */
     trksriyuukbn                                       VARCHAR     (1)                                                                 ,  /* 取消理由区分 */
     dstrhkservicekanyukeirokbn                         VARCHAR     (1)                                                                 ,  /* ＤＳ取引サービス加入経路区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE MT_DsTourokuUkKouzaAnsyono ADD CONSTRAINT PK_DsTourokuUkKouzaAnsyono PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     dsttdksyubetukbn                                         , /* ＤＳ手続種別区分 */
     datarenno                                                  /* データ連番 */
) ;
