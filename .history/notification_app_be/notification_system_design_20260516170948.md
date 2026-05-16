# Stage 1
GET /notifications
POST /notifications
PUT /notifications/{id}/read
DELETE /notifications/{id}

# Stage 2
students
notifications
notification_reads

# Stage 3
SELECT * FROM notifications
WHERE studentID = 1042 AND isRead = false
ORDER BY createdAt DESC;
