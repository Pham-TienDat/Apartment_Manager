package view;

import javax.swing.*;
import java.awt.*;

import static controller.FeeDAO.countFees;
import static controller.HouseholdDAO.countHouseholds;
import static controller.ResidentDAO.countResidents;

public class BlankWindow extends JPanel {
    int resident = countResidents();
    int households = countHouseholds();
    int fees = countFees();

    public BlankWindow() {
        setLayout(null);

        // Tiêu đề
        JLabel titleLabel = new JLabel("Trang chủ", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(0, 0, 859, 30);
        add(titleLabel);

        // Tạo các ô vuông
        createSquarePanel("Số nhân khẩu: " + resident, "img/people.png", 10, 100, 400, 250); // Phần I
        createSquarePanel("Số hộ khẩu: " + households, "img/household.png", 430, 100, 400, 250); // Phần II
        createSquarePanel("Số loại phí bắt buộc: 10", "img/fee.png", 430, 400, 400, 250); // Phần III
        createSquarePanel("Số loại phí khác: 5\nChung: 3\nRiêng: 2", "img/fee.png", 10, 400, 400, 250); // Phần IV
    }

    private void createSquarePanel(String labelText, String iconPath, int x, int y, int width, int height) {
        // Panel con để chứa nội dung
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBounds(x, y, width, height);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Thêm hình ảnh tượng trưng
        JLabel imageLabel = new JLabel(new ImageIcon(iconPath), SwingConstants.CENTER);
        panel.add(imageLabel, BorderLayout.NORTH);

        // Thêm nội dung
        JLabel contentLabel = new JLabel(labelText, SwingConstants.CENTER);
        contentLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        panel.add(contentLabel, BorderLayout.CENTER);

        add(panel);
    }
}