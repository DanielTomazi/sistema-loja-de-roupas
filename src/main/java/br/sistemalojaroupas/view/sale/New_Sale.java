package br.sistemalojaroupas.view.sale;

import br.sistemalojaroupas.model.dao.CustomerDao;
import br.sistemalojaroupas.model.dao.ProductDao;
import br.sistemalojaroupas.model.entities.Customer;
import br.sistemalojaroupas.model.entities.Product;
import br.sistemalojaroupas.model.entities.Sale;
import br.sistemalojaroupas.model.entities.SaleItem;
import br.sistemalojaroupas.model.services.SaleService;
import br.sistemalojaroupas.view.listeners.DataChangeListener;
import br.sistemalojaroupas.view.util.Utils;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class New_Sale extends javax.swing.JFrame {

    private Product product;
    private Sale sale;
    private SaleItem item;
    private boolean nextSale = true;
    private boolean hasProduct = false;
    private Customer customer;
    
    private Set<DataChangeListener> listeners = new HashSet<>();

    /**
     * Creates new form New_Sale
     */
    public New_Sale() {
        initComponents();
        btnDeleteProduct.setVisible(false);
    }
    
    public void subscribeDataChangeListener(DataChangeListener listener) {
        listeners.add(listener);
    }
    
    private void notifyListeners() {
        listeners.forEach(x -> {
            x.onDataChanged();
        });
    }
    
    public Sale getSale() {
        return sale;
    }

    private void clearProductFields() {
        txt_Code.setText("");
        txt_quantity.setText("1");
        txt_color.setText("");
        txt_price.setText("");
        txt_product.setText("");
        txt_size.setText("");
        txt_brand.setText("");
    }

    public void finishSale() {
        DefaultTableModel dtm = (DefaultTableModel) table_ShoppingCart.getModel();
        dtm.setRowCount(0);
        SaleService.confirmSale(sale);
        
        JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        
        txt_SalesTotal.setText("R$ 0,00");
        txt_CPF.setValue("");
        txt_name.setText("");
        customer = null;
        nextSale = true;
        sale = null;
        hasProduct = false;
        btnDeleteProduct.setVisible(false);
        
        notifyListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_cancellation = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        btn_searchCPF = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_product = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_brand = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_color = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_size = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_CPF = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_Code = new javax.swing.JFormattedTextField();
        txt_SalesTotal = new javax.swing.JTextField();
        btn_searchCod = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ShoppingCart = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btn_addToCart = new javax.swing.JButton();
        btn_payment = new javax.swing.JButton();
        btnDeleteProduct = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova Venda");
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(1260, 730));

        jPanel4.setBackground(new java.awt.Color(0, 0, 22));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 22));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nome :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 60, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 176, 240));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Carrinho de Compras");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 740, 40));

        btn_cancellation.setBackground(new java.awt.Color(192, 0, 0));
        btn_cancellation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancellation.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancellation.setText("Cancelar Venda");
        btn_cancellation.setBorderPainted(false);
        btn_cancellation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancellationActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancellation, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 560, 220, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CPF :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 60, 30));

        txt_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_name.setBorder(null);
        jPanel1.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 280, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 176, 240));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dados do Cliente");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 410, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Código :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 70, 30));

        txt_price.setEditable(false);
        txt_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_price.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_price.setBorder(null);
        jPanel1.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 120, 30));

        btn_searchCPF.setBackground(new java.awt.Color(108, 81, 233));
        btn_searchCPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_searchCPF.setForeground(new java.awt.Color(255, 255, 255));
        btn_searchCPF.setText("Pesquisar");
        btn_searchCPF.setBorderPainted(false);
        btn_searchCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchCPFActionPerformed(evt);
            }
        });
        jPanel1.add(btn_searchCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 150, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Produto :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 80, 30));

        txt_product.setEditable(false);
        txt_product.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_product.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_product.setBorder(null);
        txt_product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_productActionPerformed(evt);
            }
        });
        jPanel1.add(txt_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 280, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Marca :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 70, 30));

        txt_brand.setEditable(false);
        txt_brand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_brand.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_brand.setBorder(null);
        jPanel1.add(txt_brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 280, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Cor :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 50, 30));

        txt_color.setEditable(false);
        txt_color.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_color.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_color.setBorder(null);
        jPanel1.add(txt_color, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, 160, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Preço :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 90, 30));

        txt_size.setEditable(false);
        txt_size.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_size.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_size.setBorder(null);
        jPanel1.add(txt_size, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 60, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tamanho :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 90, 30));

        txt_CPF.setBorder(null);
        try {
            txt_CPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_CPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_CPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txt_CPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 120, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Qtd. :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 80, 30));

        txt_Code.setBorder(null);
        txt_Code.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txt_Code.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_Code.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(txt_Code, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 110, 30));

        txt_SalesTotal.setEditable(false);
        txt_SalesTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txt_SalesTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_SalesTotal.setText("R$ 0,00");
        txt_SalesTotal.setBorder(null);
        jPanel1.add(txt_SalesTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 560, 210, 50));

        btn_searchCod.setBackground(new java.awt.Color(108, 81, 233));
        btn_searchCod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_searchCod.setForeground(new java.awt.Color(255, 255, 255));
        btn_searchCod.setText("Pesquisar");
        btn_searchCod.setBorderPainted(false);
        btn_searchCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchCodActionPerformed(evt);
            }
        });
        jPanel1.add(btn_searchCod, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 150, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 176, 240));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Total da Venda");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, 150, 40));

        txt_quantity.setBorder(null);
        txt_quantity.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txt_quantity.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_quantity.setText("1");
        txt_quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 80, 30));

        table_ShoppingCart.setForeground(new java.awt.Color(0, 0, 51));
        table_ShoppingCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Marca", "Tam.", "Cor", "Preço", "Quantidade", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_ShoppingCart.setGridColor(new java.awt.Color(204, 204, 204));
        table_ShoppingCart.setSelectionBackground(new java.awt.Color(0, 0, 51));
        table_ShoppingCart.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_ShoppingCart.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(table_ShoppingCart);
        if (table_ShoppingCart.getColumnModel().getColumnCount() > 0) {
            table_ShoppingCart.getColumnModel().getColumn(0).setMinWidth(40);
            table_ShoppingCart.getColumnModel().getColumn(0).setPreferredWidth(80);
            table_ShoppingCart.getColumnModel().getColumn(0).setMaxWidth(150);
            table_ShoppingCart.getColumnModel().getColumn(2).setMinWidth(30);
            table_ShoppingCart.getColumnModel().getColumn(2).setPreferredWidth(80);
            table_ShoppingCart.getColumnModel().getColumn(2).setMaxWidth(150);
            table_ShoppingCart.getColumnModel().getColumn(3).setMinWidth(30);
            table_ShoppingCart.getColumnModel().getColumn(3).setPreferredWidth(50);
            table_ShoppingCart.getColumnModel().getColumn(3).setMaxWidth(100);
            table_ShoppingCart.getColumnModel().getColumn(4).setMinWidth(50);
            table_ShoppingCart.getColumnModel().getColumn(4).setPreferredWidth(100);
            table_ShoppingCart.getColumnModel().getColumn(4).setMaxWidth(200);
            table_ShoppingCart.getColumnModel().getColumn(5).setMinWidth(40);
            table_ShoppingCart.getColumnModel().getColumn(5).setPreferredWidth(60);
            table_ShoppingCart.getColumnModel().getColumn(5).setMaxWidth(100);
            table_ShoppingCart.getColumnModel().getColumn(6).setMinWidth(35);
            table_ShoppingCart.getColumnModel().getColumn(6).setPreferredWidth(80);
            table_ShoppingCart.getColumnModel().getColumn(6).setMaxWidth(150);
            table_ShoppingCart.getColumnModel().getColumn(7).setMinWidth(50);
            table_ShoppingCart.getColumnModel().getColumn(7).setPreferredWidth(80);
            table_ShoppingCart.getColumnModel().getColumn(7).setMaxWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 720, 330));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 176, 240));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Dados do Produto");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 410, 40));

        btn_addToCart.setBackground(new java.awt.Color(108, 81, 233));
        btn_addToCart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_addToCart.setForeground(new java.awt.Color(255, 255, 255));
        btn_addToCart.setText("Adicionar ao Carrinho");
        btn_addToCart.setBorderPainted(false);
        btn_addToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addToCartActionPerformed(evt);
            }
        });
        jPanel1.add(btn_addToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 570, 220, 50));

        btn_payment.setBackground(new java.awt.Color(0, 176, 80));
        btn_payment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_payment.setForeground(new java.awt.Color(255, 255, 255));
        btn_payment.setText("Pagamento");
        btn_payment.setBorderPainted(false);
        btn_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paymentActionPerformed(evt);
            }
        });
        jPanel1.add(btn_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 560, 220, 50));

        btnDeleteProduct.setBackground(new java.awt.Color(246, 20, 20));
        btnDeleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash_14px.png"))); // NOI18N
        btnDeleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteProductActionPerformed(evt);
            }
        });
        jPanel1.add(btnDeleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 372, 30, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background_VENDAS.png"))); // NOI18N
        jPanel1.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.add(jPanel1, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1254, 722));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchCodActionPerformed
        product = ProductDao.findById(Utils.tryParseToLong(txt_Code.getText()));

        if (product != null) {
            if (product.getQuantity() == 0) {
                JOptionPane.showMessageDialog(this, "Este produto não possui quantidade em estoque.",
                        "Atenção", JOptionPane.INFORMATION_MESSAGE);
                product = null;
                return;
            }
            txt_product.setText(product.getDescription());
            txt_size.setText(product.getSize());
            txt_color.setText(product.getColor().getName());
            txt_price.setText(String.format("R$ %.2f", product.getSalePrice()));
            txt_brand.setText(product.getBrand().getName());
        } else {
            JOptionPane.showMessageDialog(this, "Código inválido!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btn_searchCodActionPerformed

    private void btn_addToCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addToCartActionPerformed
        if (nextSale) {
            sale = new Sale();
            nextSale = false;
        }
        Integer quantity = Utils.tryParseToInt(txt_quantity.getText());
        if (quantity > 0 && product != null) {
            try {
                item = new SaleItem(product, quantity);
                sale.addItem(item);

                Utils.updateTable(sale.getItems(), table_ShoppingCart);
                
                if (!hasProduct) {
                    hasProduct = true;
                    btnDeleteProduct.setVisible(true);
                }
                clearProductFields();
                txt_SalesTotal.setText(String.format("R$ %.2f", sale.getTotal()));

                product = null;
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Você deve digitar um código de produto válido"
                    + " e a quantidade a ser vendida.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_addToCartActionPerformed

    private void btn_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paymentActionPerformed
        if (sale == null || nextSale) {
            JOptionPane.showMessageDialog(this, "Nenhuma operação da venda foi iniciada.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sale.getItems().size() > 0) {
            if (customer != null) {
                sale.setCustomer(customer);
            }
            new Payment(this).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Deve haver pelo menos um produto adicionado "
                    + "à lista antes de prosseguir para o pagamento.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_paymentActionPerformed

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void btn_searchCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchCPFActionPerformed
        customer = CustomerDao.findByCpf(txt_CPF.getText());
        if (customer == null) {
            JOptionPane.showMessageDialog(null, "Este CPF não está cadastrado no sistema.", 
                    "CPF inválido", JOptionPane.ERROR_MESSAGE);
            return;
        }
        txt_name.setText(customer.getName());
    }//GEN-LAST:event_btn_searchCPFActionPerformed

    private void btn_cancellationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancellationActionPerformed
        if (nextSale || !hasProduct) {
            JOptionPane.showMessageDialog(this, "Nenhuma operação da venda foi iniciada.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int option = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja cancelar a venda?",
                "Atenção!", JOptionPane.INFORMATION_MESSAGE);
        
        if (option != 0) return;
        
        DefaultTableModel dtm = (DefaultTableModel) table_ShoppingCart.getModel();
        dtm.setRowCount(0);

        clearProductFields();

        txt_SalesTotal.setText("R$ 0,00");
        txt_CPF.setValue("");
        txt_name.setText("");
        product = null;
        customer = null;
        nextSale = true;
        hasProduct = false;
        sale = null;
        btnDeleteProduct.setVisible(false);
    }//GEN-LAST:event_btn_cancellationActionPerformed

    private void btnDeleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteProductActionPerformed
        int selectedRow = table_ShoppingCart.getSelectedRow();
        
        if (selectedRow > -1) {
            DefaultTableModel dtm = (DefaultTableModel) table_ShoppingCart.getModel();
            Long id = (Long) dtm.getValueAt(selectedRow, 0);
            Product p = ProductDao.findById(id);
            
            int option = JOptionPane.showConfirmDialog(this, "Você tem certeza que quer remover o produto "
                    + "\'" + p.getDescription() + "\'" + " da lista?", "Atenção!", JOptionPane.INFORMATION_MESSAGE);
                    
            if (option != 0) return;
            
            sale.getItems().removeIf(x -> x.getProduct().equals(p));
            Utils.updateTable(sale.getItems(), table_ShoppingCart);
            txt_SalesTotal.setText(String.format("R$ %.2f", sale.getTotal()));
            
            if (sale.getItems().size() == 0) {
                btnDeleteProduct.setVisible(false);
                hasProduct = false;
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Você deve selecionar um produto para poder remover da lista.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteProductActionPerformed

    private void txt_productActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_productActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton btnDeleteProduct;
    private javax.swing.JButton btn_addToCart;
    private javax.swing.JButton btn_cancellation;
    private javax.swing.JButton btn_payment;
    private javax.swing.JButton btn_searchCPF;
    private javax.swing.JButton btn_searchCod;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_ShoppingCart;
    private javax.swing.JFormattedTextField txt_CPF;
    private javax.swing.JFormattedTextField txt_Code;
    private javax.swing.JTextField txt_SalesTotal;
    private javax.swing.JTextField txt_brand;
    private javax.swing.JTextField txt_color;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_product;
    private javax.swing.JFormattedTextField txt_quantity;
    private javax.swing.JTextField txt_size;
    // End of variables declaration//GEN-END:variables
}
