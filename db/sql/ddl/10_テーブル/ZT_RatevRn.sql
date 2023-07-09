CREATE TABLE ZT_RatevRn (
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号                                   */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分                               */
     zrnyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予定利率                                     */
     zrnpmenkbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ免区分                                     */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分                                   */
     zrnhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別                                   */
     zrnkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）契約時被保険者年令                                */
     zrnsaimnkkykhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）才満期契約表示                                  */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間                                     */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間                                    */
     zrnvrate00                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート００                                   */
     zrnvrate01                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０１                                   */
     zrnvrate02                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０２                                   */
     zrnvrate03                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０３                                   */
     zrnvrate04                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０４                                   */
     zrnvrate05                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０５                                   */
     zrnvrate06                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０６                                   */
     zrnvrate07                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０７                                   */
     zrnvrate08                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０８                                   */
     zrnvrate09                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート０９                                   */
     zrnvrate10                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１０                                   */
     zrnvrate11                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１１                                   */
     zrnvrate12                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１２                                   */
     zrnvrate13                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１３                                   */
     zrnvrate14                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１４                                   */
     zrnvrate15                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１５                                   */
     zrnvrate16                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１６                                   */
     zrnvrate17                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１７                                   */
     zrnvrate18                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１８                                   */
     zrnvrate19                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート１９                                   */
     zrnvrate20                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２０                                   */
     zrnvrate21                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２１                                   */
     zrnvrate22                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２２                                   */
     zrnvrate23                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２３                                   */
     zrnvrate24                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２４                                   */
     zrnvrate25                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２５                                   */
     zrnvrate26                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２６                                   */
     zrnvrate27                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２７                                   */
     zrnvrate28                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２８                                   */
     zrnvrate29                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート２９                                   */
     zrnvrate30                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３０                                   */
     zrnvrate31                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３１                                   */
     zrnvrate32                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３２                                   */
     zrnvrate33                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３３                                   */
     zrnvrate34                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３４                                   */
     zrnvrate35                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３５                                   */
     zrnvrate36                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３６                                   */
     zrnvrate37                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３７                                   */
     zrnvrate38                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３８                                   */
     zrnvrate39                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート３９                                   */
     zrnvrate40                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４０                                   */
     zrnvrate41                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４１                                   */
     zrnvrate42                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４２                                   */
     zrnvrate43                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４３                                   */
     zrnvrate44                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４４                                   */
     zrnvrate45                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４５                                   */
     zrnvrate46                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４６                                   */
     zrnvrate47                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４７                                   */
     zrnvrate48                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４８                                   */
     zrnvrate49                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート４９                                   */
     zrnvrate50                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５０                                   */
     zrnvrate51                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５１                                   */
     zrnvrate52                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５２                                   */
     zrnvrate53                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５３                                   */
     zrnvrate54                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５４                                   */
     zrnvrate55                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５５                                   */
     zrnvrate56                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５６                                   */
     zrnvrate57                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５７                                   */
     zrnvrate58                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５８                                   */
     zrnvrate59                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート５９                                   */
     zrnvrate60                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６０                                   */
     zrnvrate61                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６１                                   */
     zrnvrate62                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６２                                   */
     zrnvrate63                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６３                                   */
     zrnvrate64                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６４                                   */
     zrnvrate65                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６５                                   */
     zrnvrate66                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６６                                   */
     zrnvrate67                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６７                                   */
     zrnvrate68                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６８                                   */
     zrnvrate69                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート６９                                   */
     zrnvrate70                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７０                                   */
     zrnvrate71                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７１                                   */
     zrnvrate72                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７２                                   */
     zrnvrate73                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７３                                   */
     zrnvrate74                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７４                                   */
     zrnvrate75                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７５                                   */
     zrnvrate76                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７６                                   */
     zrnvrate77                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７７                                   */
     zrnvrate78                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７８                                   */
     zrnvrate79                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート７９                                   */
     zrnvrate80                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８０                                   */
     zrnvrate81                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８１                                   */
     zrnvrate82                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８２                                   */
     zrnvrate83                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８３                                   */
     zrnvrate84                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８４                                   */
     zrnvrate85                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８５                                   */
     zrnvrate86                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８６                                   */
     zrnvrate87                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８７                                   */
     zrnvrate88                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８８                                   */
     zrnvrate89                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート８９                                   */
     zrnvrate90                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９０                                   */
     zrnvrate91                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９１                                   */
     zrnvrate92                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９２                                   */
     zrnvrate93                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９３                                   */
     zrnvrate94                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９４                                   */
     zrnvrate95                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９５                                   */
     zrnvrate96                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９６                                   */
     zrnvrate97                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９７                                   */
     zrnvrate98                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｖレート９８                                   */
     zrnvrate99                                         NUMBER      (9,6)                                                     NOT NULL     /* （連携用）Ｖレート９９                                   */
)
;

ALTER TABLE ZT_RatevRn ADD CONSTRAINT PK_RatevRn PRIMARY KEY (
     zrnhknsyukigou                                           , /* （連携用）保険種類記号                                    */
     zrnhknsyuruikigousedaikbn                                , /* （連携用）保険種類記号世代区分                                */
     zrnyoteiriritu                                           , /* （連携用）予定利率                                      */
     zrnpmenkbn                                               , /* （連携用）Ｐ免区分                                      */
     zrnhrkkaisuukbn                                          , /* （連携用）払込回数区分                                    */
     zrnhhknsei                                               , /* （連携用）被保険者性別                                    */
     zrnkeiyakujihhknnen                                      , /* （連携用）契約時被保険者年令                                 */
     zrnsaimnkkykhyj                                          , /* （連携用）才満期契約表示                                   */
     zrnhknkkn                                                , /* （連携用）保険期間                                      */
     zrnphrkkikn                                                /* （連携用）Ｐ払込期間                                     */
) ;
