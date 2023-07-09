CREATE TABLE BM_RisaHitSyouhnyouRateD (
     palhokensyuruikigou                                CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ予定利率 */
     palpmencode                                        CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                 CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ払込回数 */
     palhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                  CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                      CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険期間 */
     palpharaikomikikan                                 CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬＰ払込期間 */
     paldnendo                                          CHAR        (4)                                                       NOT NULL  ,  /* ＰＡＬＤ年度 */
     paldratenaikakucode                                CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬＤレート内定確定コード */
     drate00                                            NUMBER      (9,6)                                                               ,  /* Ｄレート００ */
     drate01                                            NUMBER      (9,6)                                                               ,  /* Ｄレート０１ */
     drate02                                            NUMBER      (9,6)                                                               ,  /* Ｄレート０２ */
     drate03                                            NUMBER      (9,6)                                                               ,  /* Ｄレート０３ */
     drate04                                            NUMBER      (9,6)                                                               ,  /* Ｄレート０４ */
     drate05                                            NUMBER      (9,6)                                                               ,  /* Ｄレート０５ */
     drate06                                            NUMBER      (9,6)                                                               ,  /* Ｄレート０６ */
     drate07                                            NUMBER      (9,6)                                                               ,  /* Ｄレート０７ */
     drate08                                            NUMBER      (9,6)                                                               ,  /* Ｄレート０８ */
     drate09                                            NUMBER      (9,6)                                                               ,  /* Ｄレート０９ */
     drate10                                            NUMBER      (9,6)                                                               ,  /* Ｄレート１０ */
     drate11                                            NUMBER      (9,6)                                                               ,  /* Ｄレート１１ */
     drate12                                            NUMBER      (9,6)                                                               ,  /* Ｄレート１２ */
     drate13                                            NUMBER      (9,6)                                                               ,  /* Ｄレート１３ */
     drate14                                            NUMBER      (9,6)                                                               ,  /* Ｄレート１４ */
     drate15                                            NUMBER      (9,6)                                                               ,  /* Ｄレート１５ */
     drate16                                            NUMBER      (9,6)                                                               ,  /* Ｄレート１６ */
     drate17                                            NUMBER      (9,6)                                                               ,  /* Ｄレート１７ */
     drate18                                            NUMBER      (9,6)                                                               ,  /* Ｄレート１８ */
     drate19                                            NUMBER      (9,6)                                                               ,  /* Ｄレート１９ */
     drate20                                            NUMBER      (9,6)                                                               ,  /* Ｄレート２０ */
     drate21                                            NUMBER      (9,6)                                                               ,  /* Ｄレート２１ */
     drate22                                            NUMBER      (9,6)                                                               ,  /* Ｄレート２２ */
     drate23                                            NUMBER      (9,6)                                                               ,  /* Ｄレート２３ */
     drate24                                            NUMBER      (9,6)                                                               ,  /* Ｄレート２４ */
     drate25                                            NUMBER      (9,6)                                                               ,  /* Ｄレート２５ */
     drate26                                            NUMBER      (9,6)                                                               ,  /* Ｄレート２６ */
     drate27                                            NUMBER      (9,6)                                                               ,  /* Ｄレート２７ */
     drate28                                            NUMBER      (9,6)                                                               ,  /* Ｄレート２８ */
     drate29                                            NUMBER      (9,6)                                                               ,  /* Ｄレート２９ */
     drate30                                            NUMBER      (9,6)                                                               ,  /* Ｄレート３０ */
     drate31                                            NUMBER      (9,6)                                                               ,  /* Ｄレート３１ */
     drate32                                            NUMBER      (9,6)                                                               ,  /* Ｄレート３２ */
     drate33                                            NUMBER      (9,6)                                                               ,  /* Ｄレート３３ */
     drate34                                            NUMBER      (9,6)                                                               ,  /* Ｄレート３４ */
     drate35                                            NUMBER      (9,6)                                                               ,  /* Ｄレート３５ */
     drate36                                            NUMBER      (9,6)                                                               ,  /* Ｄレート３６ */
     drate37                                            NUMBER      (9,6)                                                               ,  /* Ｄレート３７ */
     drate38                                            NUMBER      (9,6)                                                               ,  /* Ｄレート３８ */
     drate39                                            NUMBER      (9,6)                                                               ,  /* Ｄレート３９ */
     drate40                                            NUMBER      (9,6)                                                               ,  /* Ｄレート４０ */
     drate41                                            NUMBER      (9,6)                                                               ,  /* Ｄレート４１ */
     drate42                                            NUMBER      (9,6)                                                               ,  /* Ｄレート４２ */
     drate43                                            NUMBER      (9,6)                                                               ,  /* Ｄレート４３ */
     drate44                                            NUMBER      (9,6)                                                               ,  /* Ｄレート４４ */
     drate45                                            NUMBER      (9,6)                                                               ,  /* Ｄレート４５ */
     drate46                                            NUMBER      (9,6)                                                               ,  /* Ｄレート４６ */
     drate47                                            NUMBER      (9,6)                                                               ,  /* Ｄレート４７ */
     drate48                                            NUMBER      (9,6)                                                               ,  /* Ｄレート４８ */
     drate49                                            NUMBER      (9,6)                                                               ,  /* Ｄレート４９ */
     drate50                                            NUMBER      (9,6)                                                               ,  /* Ｄレート５０ */
     drate51                                            NUMBER      (9,6)                                                               ,  /* Ｄレート５１ */
     drate52                                            NUMBER      (9,6)                                                               ,  /* Ｄレート５２ */
     drate53                                            NUMBER      (9,6)                                                               ,  /* Ｄレート５３ */
     drate54                                            NUMBER      (9,6)                                                               ,  /* Ｄレート５４ */
     drate55                                            NUMBER      (9,6)                                                               ,  /* Ｄレート５５ */
     drate56                                            NUMBER      (9,6)                                                               ,  /* Ｄレート５６ */
     drate57                                            NUMBER      (9,6)                                                               ,  /* Ｄレート５７ */
     drate58                                            NUMBER      (9,6)                                                               ,  /* Ｄレート５８ */
     drate59                                            NUMBER      (9,6)                                                               ,  /* Ｄレート５９ */
     drate60                                            NUMBER      (9,6)                                                               ,  /* Ｄレート６０ */
     drate61                                            NUMBER      (9,6)                                                               ,  /* Ｄレート６１ */
     drate62                                            NUMBER      (9,6)                                                               ,  /* Ｄレート６２ */
     drate63                                            NUMBER      (9,6)                                                               ,  /* Ｄレート６３ */
     drate64                                            NUMBER      (9,6)                                                               ,  /* Ｄレート６４ */
     drate65                                            NUMBER      (9,6)                                                               ,  /* Ｄレート６５ */
     drate66                                            NUMBER      (9,6)                                                               ,  /* Ｄレート６６ */
     drate67                                            NUMBER      (9,6)                                                               ,  /* Ｄレート６７ */
     drate68                                            NUMBER      (9,6)                                                               ,  /* Ｄレート６８ */
     drate69                                            NUMBER      (9,6)                                                               ,  /* Ｄレート６９ */
     drate70                                            NUMBER      (9,6)                                                               ,  /* Ｄレート７０ */
     drate71                                            NUMBER      (9,6)                                                               ,  /* Ｄレート７１ */
     drate72                                            NUMBER      (9,6)                                                               ,  /* Ｄレート７２ */
     drate73                                            NUMBER      (9,6)                                                               ,  /* Ｄレート７３ */
     drate74                                            NUMBER      (9,6)                                                               ,  /* Ｄレート７４ */
     drate75                                            NUMBER      (9,6)                                                               ,  /* Ｄレート７５ */
     drate76                                            NUMBER      (9,6)                                                               ,  /* Ｄレート７６ */
     drate77                                            NUMBER      (9,6)                                                               ,  /* Ｄレート７７ */
     drate78                                            NUMBER      (9,6)                                                               ,  /* Ｄレート７８ */
     drate79                                            NUMBER      (9,6)                                                               ,  /* Ｄレート７９ */
     drate80                                            NUMBER      (9,6)                                                               ,  /* Ｄレート８０ */
     drate81                                            NUMBER      (9,6)                                                               ,  /* Ｄレート８１ */
     drate82                                            NUMBER      (9,6)                                                               ,  /* Ｄレート８２ */
     drate83                                            NUMBER      (9,6)                                                               ,  /* Ｄレート８３ */
     drate84                                            NUMBER      (9,6)                                                               ,  /* Ｄレート８４ */
     drate85                                            NUMBER      (9,6)                                                               ,  /* Ｄレート８５ */
     drate86                                            NUMBER      (9,6)                                                               ,  /* Ｄレート８６ */
     drate87                                            NUMBER      (9,6)                                                               ,  /* Ｄレート８７ */
     drate88                                            NUMBER      (9,6)                                                               ,  /* Ｄレート８８ */
     drate89                                            NUMBER      (9,6)                                                               ,  /* Ｄレート８９ */
     drate90                                            NUMBER      (9,6)                                                               ,  /* Ｄレート９０ */
     drate91                                            NUMBER      (9,6)                                                               ,  /* Ｄレート９１ */
     drate92                                            NUMBER      (9,6)                                                               ,  /* Ｄレート９２ */
     drate93                                            NUMBER      (9,6)                                                               ,  /* Ｄレート９３ */
     drate94                                            NUMBER      (9,6)                                                               ,  /* Ｄレート９４ */
     drate95                                            NUMBER      (9,6)                                                               ,  /* Ｄレート９５ */
     drate96                                            NUMBER      (9,6)                                                               ,  /* Ｄレート９６ */
     drate97                                            NUMBER      (9,6)                                                               ,  /* Ｄレート９７ */
     drate98                                            NUMBER      (9,6)                                                               ,  /* Ｄレート９８ */
     drate99                                            NUMBER      (9,6)                                                               ,  /* Ｄレート９９ */
     dyouvrate00                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート００ */
     dyouvrate01                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート０１ */
     dyouvrate02                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート０２ */
     dyouvrate03                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート０３ */
     dyouvrate04                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート０４ */
     dyouvrate05                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート０５ */
     dyouvrate06                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート０６ */
     dyouvrate07                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート０７ */
     dyouvrate08                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート０８ */
     dyouvrate09                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート０９ */
     dyouvrate10                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート１０ */
     dyouvrate11                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート１１ */
     dyouvrate12                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート１２ */
     dyouvrate13                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート１３ */
     dyouvrate14                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート１４ */
     dyouvrate15                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート１５ */
     dyouvrate16                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート１６ */
     dyouvrate17                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート１７ */
     dyouvrate18                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート１８ */
     dyouvrate19                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート１９ */
     dyouvrate20                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート２０ */
     dyouvrate21                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート２１ */
     dyouvrate22                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート２２ */
     dyouvrate23                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート２３ */
     dyouvrate24                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート２４ */
     dyouvrate25                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート２５ */
     dyouvrate26                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート２６ */
     dyouvrate27                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート２７ */
     dyouvrate28                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート２８ */
     dyouvrate29                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート２９ */
     dyouvrate30                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート３０ */
     dyouvrate31                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート３１ */
     dyouvrate32                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート３２ */
     dyouvrate33                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート３３ */
     dyouvrate34                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート３４ */
     dyouvrate35                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート３５ */
     dyouvrate36                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート３６ */
     dyouvrate37                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート３７ */
     dyouvrate38                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート３８ */
     dyouvrate39                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート３９ */
     dyouvrate40                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート４０ */
     dyouvrate41                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート４１ */
     dyouvrate42                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート４２ */
     dyouvrate43                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート４３ */
     dyouvrate44                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート４４ */
     dyouvrate45                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート４５ */
     dyouvrate46                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート４６ */
     dyouvrate47                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート４７ */
     dyouvrate48                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート４８ */
     dyouvrate49                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート４９ */
     dyouvrate50                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート５０ */
     dyouvrate51                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート５１ */
     dyouvrate52                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート５２ */
     dyouvrate53                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート５３ */
     dyouvrate54                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート５４ */
     dyouvrate55                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート５５ */
     dyouvrate56                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート５６ */
     dyouvrate57                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート５７ */
     dyouvrate58                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート５８ */
     dyouvrate59                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート５９ */
     dyouvrate60                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート６０ */
     dyouvrate61                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート６１ */
     dyouvrate62                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート６２ */
     dyouvrate63                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート６３ */
     dyouvrate64                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート６４ */
     dyouvrate65                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート６５ */
     dyouvrate66                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート６６ */
     dyouvrate67                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート６７ */
     dyouvrate68                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート６８ */
     dyouvrate69                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート６９ */
     dyouvrate70                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート７０ */
     dyouvrate71                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート７１ */
     dyouvrate72                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート７２ */
     dyouvrate73                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート７３ */
     dyouvrate74                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート７４ */
     dyouvrate75                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート７５ */
     dyouvrate76                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート７６ */
     dyouvrate77                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート７７ */
     dyouvrate78                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート７８ */
     dyouvrate79                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート７９ */
     dyouvrate80                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート８０ */
     dyouvrate81                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート８１ */
     dyouvrate82                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート８２ */
     dyouvrate83                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート８３ */
     dyouvrate84                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート８４ */
     dyouvrate85                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート８５ */
     dyouvrate86                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート８６ */
     dyouvrate87                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート８７ */
     dyouvrate88                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート８８ */
     dyouvrate89                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート８９ */
     dyouvrate90                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート９０ */
     dyouvrate91                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート９１ */
     dyouvrate92                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート９２ */
     dyouvrate93                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート９３ */
     dyouvrate94                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート９４ */
     dyouvrate95                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート９５ */
     dyouvrate96                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート９６ */
     dyouvrate97                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート９７ */
     dyouvrate98                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート９８ */
     dyouvrate99                                        NUMBER      (9,6)                                                               ,  /* Ｄ用Ｖレート９９ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_RisaHitSyouhnyouRateD ADD CONSTRAINT PK_RisaHitSyouhnyouRateD PRIMARY KEY (
     palhokensyuruikigou                                      , /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                               , /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                           , /* ＰＡＬ予定利率 */
     palpmencode                                              , /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                       , /* ＰＡＬ払込回数 */
     palhhknsei                                               , /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                      , /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                        , /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                            , /* ＰＡＬ保険期間 */
     palpharaikomikikan                                       , /* ＰＡＬＰ払込期間 */
     paldnendo                                                , /* ＰＡＬＤ年度 */
     paldratenaikakucode                                        /* ＰＡＬＤレート内定確定コード */
) ;
