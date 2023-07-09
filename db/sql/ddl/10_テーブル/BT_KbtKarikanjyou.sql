CREATE TABLE BT_KbtKarikanjyou (
     kbtkarikanjyouskbtkey                              NUMBER      (8)                                                       NOT NULL  ,  /* 個別仮勘定識別キー */
     densyskbn                                          VARCHAR     (2)                                                                 ,  /* 伝票用システム区分 */
     denrenno                                           VARCHAR     (20)                                                                ,  /* 伝票データ連番 */
     edano                                              NUMBER      (2)                                                                 ,  /* 枝番号 */
     keirisyono                                         VARCHAR     (20)                                                                ,  /* 経理用証券番号 */
     nyuukinkakusyouno                                  VARCHAR     (20)                                                                ,  /* 入金確証番号 */
     hurikaedenskssyoriymd                              VARCHAR     (8)                                                                 ,  /* 振替伝票作成処理年月日 */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     huridenatesakicd                                   VARCHAR     (3)                                                                 ,  /* 振替伝票宛先部課コード */
     taisyakukbn                                        VARCHAR     (1)                                                                 ,  /* 貸借区分 */
     kanjyoukmkcd                                       VARCHAR     (5)                                                                 ,  /* 勘定科目コード */
     denyenkagk                                         NUMBER      (13)                                                                ,  /* 伝票金額（円） */
     denyenkagk$                                        VARCHAR     (10)                                                                ,  /* 伝票金額（円）(通貨型) */
     syoricd                                            VARCHAR     (4)                                                                 ,  /* 処理コード */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード */
     kbtkarikanjyoukbn                                  VARCHAR     (2)                                                                 ,  /* 個別仮勘定区分 */
     kskmkanryouymd                                     VARCHAR     (8)                                                                 ,  /* 消込完了年月日 */
     seg1cd                                             VARCHAR     (20)                                                                ,  /* セグメント１コード */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_KbtKarikanjyou ADD CONSTRAINT PK_KbtKarikanjyou PRIMARY KEY (
     kbtkarikanjyouskbtkey                                      /* 個別仮勘定識別キー */
) ;

CREATE INDEX IX1_KbtKarikanjyou ON BT_KbtKarikanjyou (
     denymd                                                     /* 伝票日付 */
) ;

CREATE INDEX IX2_KbtKarikanjyou ON BT_KbtKarikanjyou (
     keirisyono                                                 /* 経理用証券番号 */
) ;
