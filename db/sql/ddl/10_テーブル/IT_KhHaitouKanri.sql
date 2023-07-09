CREATE TABLE IT_KhHaitouKanri (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     haitounendo                                        VARCHAR     (4)                                                       NOT NULL  ,  /* 配当年度 */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番 */
     haitoukinskskbn                                    VARCHAR     (2)                                                       NOT NULL  ,  /* 配当金作成区分 */
     haitoumeisaikbn                                    VARCHAR     (2)                                                       NOT NULL  ,  /* 配当明細区分 */
     fstkariwariatednendo                               VARCHAR     (4)                                                                 ,  /* 初回仮割当Ｄ年度 */
     tounendod                                          NUMBER      (13)                                                                ,  /* 当年度Ｄ */
     tounendod$                                         VARCHAR     (10)                                                                ,  /* 当年度Ｄ(通貨型) */
     naiteikakuteikbn                                   VARCHAR     (1)                                                                 ,  /* 内定確定区分 */
     kariwariatedshrymd                                 VARCHAR     (8)                                                                 ,  /* 仮割当Ｄ支払年月日 */
     kariwariatedruigk                                  NUMBER      (13)                                                                ,  /* 仮割当Ｄ累計額 */
     kariwariatedruigk$                                 VARCHAR     (10)                                                                ,  /* 仮割当Ｄ累計額(通貨型) */
     kariwariatedgngkkngk                               NUMBER      (13)                                                                ,  /* 仮割当Ｄ減額金額 */
     kariwariatedgngkkngk$                              VARCHAR     (10)                                                                ,  /* 仮割当Ｄ減額金額(通貨型) */
     kariwariatedshrgk                                  NUMBER      (13)                                                                ,  /* 仮割当Ｄ支払額 */
     kariwariatedshrgk$                                 VARCHAR     (10)                                                                ,  /* 仮割当Ｄ支払額(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhHaitouKanri ADD CONSTRAINT PK_HaitouKanri PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     haitounendo                                              , /* 配当年度 */
     renno                                                    , /* 連番 */
     haitoukinskskbn                                          , /* 配当金作成区分 */
     haitoumeisaikbn                                            /* 配当明細区分 */
) ;

CREATE INDEX IX1_HaitouKanri ON IT_KhHaitouKanri (
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX2_HaitouKanri ON IT_KhHaitouKanri (
     haitounendo                                                /* 配当年度 */
) ;
